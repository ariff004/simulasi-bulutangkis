package com.example.viewmodel

import android.app.Application
import android.content.Context
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import android.os.VibratorManager
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.QuizRepository
import com.example.model.HighScoreRecord
import com.example.model.Question
import com.example.model.QuestionReview
import com.example.model.QuizCategory
import com.example.model.QuizMode
import com.example.model.QuizResult
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

enum class ScreenState {
    HOME,
    QUIZ,
    RESULT,
    LEADERBOARD,
    TRIVIA
}

data class QuizUiState(
    val currentScreen: ScreenState = ScreenState.HOME,
    val selectedCategory: QuizCategory = QuizCategory.ALL,
    val selectedMode: QuizMode = QuizMode.STANDARD,
    val questions: List<Question> = emptyList(),
    val currentIndex: Int = 0,
    val selectedOptionIndex: Int? = null,
    val isSubmitted: Boolean = false,
    val lastAnswerCorrect: Boolean? = null,
    val score: Int = 0,
    val streak: Int = 0,
    val maxStreak: Int = 0,
    val timeLeft: Int = 20,
    val isTimerActive: Boolean = false,
    val eliminatedOptions: Set<Int> = emptySet(),
    val isLifeline5050Available: Boolean = true,
    val isLifelineHintAvailable: Boolean = true,
    val showHintDialog: Boolean = false,
    val activeHint: String = "",
    val reviews: List<QuestionReview> = emptyList(),
    val quizResult: QuizResult? = null,
    val highScores: List<HighScoreRecord> = emptyList(),
    val bestOverallScore: Int = 0,
    val totalGamesPlayed: Int = 0,
    val playerNameInput: String = "",
    val isScoreSaved: Boolean = false,
    val showQuitConfirmDialog: Boolean = false
)

class QuizViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = QuizRepository(application.applicationContext)
    private val vibrator: Vibrator? = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        val vibratorManager = application.getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as? VibratorManager
        vibratorManager?.defaultVibrator
    } else {
        @Suppress("DEPRECATION")
        application.getSystemService(Context.VIBRATOR_SERVICE) as? Vibrator
    }

    private val _uiState = MutableStateFlow(QuizUiState())
    val uiState: StateFlow<QuizUiState> = _uiState.asStateFlow()

    private var timerJob: Job? = null

    init {
        loadDashboardStats()
    }

    fun loadDashboardStats() {
        val scores = repository.getHighScores()
        val best = repository.getBestOverallScore()
        val total = repository.getTotalGamesPlayed()
        _uiState.update {
            it.copy(
                highScores = scores,
                bestOverallScore = best,
                totalGamesPlayed = total
            )
        }
    }

    fun navigateTo(screen: ScreenState) {
        if (screen == ScreenState.LEADERBOARD) {
            loadDashboardStats()
        }
        _uiState.update { it.copy(currentScreen = screen) }
    }

    fun selectCategory(category: QuizCategory) {
        _uiState.update { it.copy(selectedCategory = category) }
    }

    fun selectMode(mode: QuizMode) {
        _uiState.update { it.copy(selectedMode = mode) }
    }

    fun startQuiz() {
        val state = _uiState.value
        val questions = repository.getQuestionsForSession(state.selectedCategory, state.selectedMode)

        if (questions.isEmpty()) return

        _uiState.update {
            it.copy(
                currentScreen = ScreenState.QUIZ,
                questions = questions,
                currentIndex = 0,
                selectedOptionIndex = null,
                isSubmitted = false,
                lastAnswerCorrect = null,
                score = 0,
                streak = 0,
                maxStreak = 0,
                eliminatedOptions = emptySet(),
                isLifeline5050Available = true,
                isLifelineHintAvailable = true,
                showHintDialog = false,
                activeHint = "",
                reviews = emptyList(),
                quizResult = null,
                isScoreSaved = false,
                showQuitConfirmDialog = false
            )
        }

        startTimerForCurrentQuestion()
    }

    private fun startTimerForCurrentQuestion() {
        timerJob?.cancel()
        val mode = _uiState.value.selectedMode
        if (mode.timePerQuestionSec <= 0) {
            // Relax mode has no countdown timer
            _uiState.update { it.copy(isTimerActive = false, timeLeft = 0) }
            return
        }

        _uiState.update { it.copy(timeLeft = mode.timePerQuestionSec, isTimerActive = true) }

        timerJob = viewModelScope.launch {
            while (_uiState.value.timeLeft > 0 && !_uiState.value.isSubmitted) {
                delay(1000L)
                if (!_uiState.value.isSubmitted) {
                    val remaining = _uiState.value.timeLeft - 1
                    _uiState.update { it.copy(timeLeft = remaining) }
                    if (remaining == 0) {
                        handleTimeOut()
                    }
                }
            }
        }
    }

    fun selectOption(index: Int) {
        val state = _uiState.value
        if (state.isSubmitted) return
        if (state.eliminatedOptions.contains(index)) return

        _uiState.update { it.copy(selectedOptionIndex = index) }
        submitAnswer(index)
    }

    private fun submitAnswer(selectedIdx: Int) {
        timerJob?.cancel()
        val state = _uiState.value
        val currentQuestion = state.questions[state.currentIndex]
        val isCorrect = selectedIdx == currentQuestion.correctAnswerIndex

        val newStreak = if (isCorrect) state.streak + 1 else 0
        val newMaxStreak = maxOf(state.maxStreak, newStreak)

        var pointsEarned = 0
        if (isCorrect) {
            val base = currentQuestion.difficulty.basePoints
            // Speed bonus: up to 50 points if answered fast
            val speedBonus = if (state.selectedMode.timePerQuestionSec > 0) {
                (state.timeLeft * 4).coerceAtMost(50)
            } else 0

            // Streak multiplier: 10% bonus per combo
            val streakMultiplier = 1.0 + (newStreak - 1).coerceAtLeast(0) * 0.15
            pointsEarned = ((base + speedBonus) * streakMultiplier).toInt()
        }

        val updatedReviews = state.reviews + QuestionReview(
            question = currentQuestion,
            selectedOptionIndex = selectedIdx,
            isCorrect = isCorrect,
            isTimedOut = false,
            pointsEarned = pointsEarned
        )

        triggerHaptic(isCorrect)

        _uiState.update {
            it.copy(
                isSubmitted = true,
                lastAnswerCorrect = isCorrect,
                score = it.score + pointsEarned,
                streak = newStreak,
                maxStreak = newMaxStreak,
                isTimerActive = false,
                reviews = updatedReviews
            )
        }
    }

    private fun handleTimeOut() {
        val state = _uiState.value
        if (state.isSubmitted) return

        val currentQuestion = state.questions[state.currentIndex]
        val updatedReviews = state.reviews + QuestionReview(
            question = currentQuestion,
            selectedOptionIndex = null,
            isCorrect = false,
            isTimedOut = true,
            pointsEarned = 0
        )

        triggerHaptic(false)

        _uiState.update {
            it.copy(
                isSubmitted = true,
                lastAnswerCorrect = false,
                streak = 0,
                isTimerActive = false,
                reviews = updatedReviews
            )
        }
    }

    fun useLifeline5050() {
        val state = _uiState.value
        if (!state.isLifeline5050Available || state.isSubmitted) return

        val currentQuestion = state.questions[state.currentIndex]
        val wrongIndices = currentQuestion.options.indices.filter { it != currentQuestion.correctAnswerIndex }
        val toEliminate = wrongIndices.shuffled().take(2).toSet()

        _uiState.update {
            it.copy(
                eliminatedOptions = toEliminate,
                isLifeline5050Available = false
            )
        }
    }

    fun useLifelineHint() {
        val state = _uiState.value
        if (!state.isLifelineHintAvailable || state.isSubmitted) return

        val currentQuestion = state.questions[state.currentIndex]
        val hintMsg = currentQuestion.hint.ifEmpty { "Pertanyaan ini berakar pada era ${currentQuestion.era}." }

        _uiState.update {
            it.copy(
                activeHint = hintMsg,
                showHintDialog = true,
                isLifelineHintAvailable = false
            )
        }
    }

    fun dismissHintDialog() {
        _uiState.update { it.copy(showHintDialog = false) }
    }

    fun skipQuestion() {
        val state = _uiState.value
        if (state.isSubmitted) return

        timerJob?.cancel()
        val currentQuestion = state.questions[state.currentIndex]
        val updatedReviews = state.reviews + QuestionReview(
            question = currentQuestion,
            selectedOptionIndex = null,
            isCorrect = false,
            isTimedOut = false,
            pointsEarned = 0
        )

        _uiState.update {
            it.copy(
                reviews = updatedReviews
            )
        }

        goToNextQuestionOrFinish()
    }

    fun nextQuestion() {
        goToNextQuestionOrFinish()
    }

    private fun goToNextQuestionOrFinish() {
        val state = _uiState.value
        val nextIdx = state.currentIndex + 1

        if (nextIdx < state.questions.size) {
            _uiState.update {
                it.copy(
                    currentIndex = nextIdx,
                    selectedOptionIndex = null,
                    isSubmitted = false,
                    lastAnswerCorrect = null,
                    eliminatedOptions = emptySet(),
                    showHintDialog = false,
                    activeHint = ""
                )
            }
            startTimerForCurrentQuestion()
        } else {
            finishQuiz()
        }
    }

    private fun finishQuiz() {
        timerJob?.cancel()
        val state = _uiState.value
        val total = state.questions.size
        val correct = state.reviews.count { it.isCorrect }
        val wrong = total - correct
        val accuracy = if (total > 0) ((correct.toFloat() / total.toFloat()) * 100).toInt() else 0

        val (rankTitle, rankBadge) = when {
            accuracy >= 90 -> Pair("Mahaguru Sejarah", "🏛️")
            accuracy >= 75 -> Pair("Sejarawan Ulung", "📜")
            accuracy >= 55 -> Pair("Peneliti Arkeologi", "🏺")
            accuracy >= 35 -> Pair("Pelajar Sejarah", "📖")
            else -> Pair("Penjelajah Waktu Pemula", "🧭")
        }

        val result = QuizResult(
            finalScore = state.score,
            correctCount = correct,
            wrongCount = wrong,
            totalQuestions = total,
            maxStreak = state.maxStreak,
            accuracyPercent = accuracy,
            rankTitle = rankTitle,
            rankBadge = rankBadge,
            reviews = state.reviews,
            category = state.selectedCategory,
            mode = state.selectedMode
        )

        _uiState.update {
            it.copy(
                currentScreen = ScreenState.RESULT,
                quizResult = result,
                isTimerActive = false
            )
        }
    }

    fun updatePlayerName(name: String) {
        _uiState.update { it.copy(playerNameInput = name) }
    }

    fun saveScoreToLeaderboard() {
        val state = _uiState.value
        val result = state.quizResult ?: return
        if (state.isScoreSaved) return

        repository.saveHighScore(
            playerName = state.playerNameInput,
            score = result.finalScore,
            category = result.category,
            mode = result.mode,
            accuracy = result.accuracyPercent
        )

        _uiState.update { it.copy(isScoreSaved = true) }
        loadDashboardStats()
    }

    fun showQuitDialog(show: Boolean) {
        _uiState.update { it.copy(showQuitConfirmDialog = show) }
    }

    fun quitQuizToHome() {
        timerJob?.cancel()
        _uiState.update {
            it.copy(
                currentScreen = ScreenState.HOME,
                showQuitConfirmDialog = false,
                isTimerActive = false
            )
        }
        loadDashboardStats()
    }

    fun clearAllHighScores() {
        repository.clearHighScores()
        loadDashboardStats()
    }

    private fun triggerHaptic(success: Boolean) {
        try {
            vibrator?.let { v ->
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    val effect = if (success) {
                        VibrationEffect.createOneShot(45, VibrationEffect.DEFAULT_AMPLITUDE)
                    } else {
                        VibrationEffect.createWaveform(longArrayOf(0, 50, 40, 50), -1)
                    }
                    v.vibrate(effect)
                } else {
                    @Suppress("DEPRECATION")
                    v.vibrate(if (success) 50 else 100)
                }
            }
        } catch (_: Exception) {
            // Ignore if vibration fails or is disabled
        }
    }

    override fun onCleared() {
        super.onCleared()
        timerJob?.cancel()
    }
}
