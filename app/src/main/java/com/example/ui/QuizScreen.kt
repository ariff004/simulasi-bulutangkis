package com.example.ui

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Filter2
import androidx.compose.material.icons.filled.HelpOutline
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material.icons.filled.SkipNext
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.Difficulty
import com.example.ui.theme.CinzelFontFamily
import com.example.ui.theme.HistoricBronze
import com.example.ui.theme.HistoricGoldDark
import com.example.ui.theme.HistoricGoldPrimary
import com.example.ui.theme.QuizCorrect
import com.example.ui.theme.QuizTimerAlert
import com.example.ui.theme.QuizWrong
import com.example.viewmodel.QuizUiState
import com.example.viewmodel.QuizViewModel

@Composable
fun QuizScreen(
    state: QuizUiState,
    viewModel: QuizViewModel
) {
    BackHandler {
        viewModel.showQuitDialog(true)
    }

    if (state.questions.isEmpty() || state.currentIndex >= state.questions.size) {
        return
    }

    val currentQuestion = state.questions[state.currentIndex]
    val totalTime = state.selectedMode.timePerQuestionSec
    val progress = if (totalTime > 0) (state.timeLeft.toFloat() / totalTime.toFloat()).coerceIn(0f, 1f) else 1f
    val animatedProgress by animateFloatAsState(targetValue = progress, label = "timerProgress")

    val timerColor by animateColorAsState(
        targetValue = if (state.timeLeft <= 5 && totalTime > 0) QuizTimerAlert else HistoricGoldPrimary,
        label = "timerColor"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .navigationBarsPadding()
            .testTag("quiz_screen")
    ) {
        // Top App Bar: Exit & Progress
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 4.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(
                onClick = { viewModel.showQuitDialog(true) },
                modifier = Modifier.testTag("exit_quiz_button")
            ) {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = "Keluar Kuis",
                    tint = MaterialTheme.colorScheme.onSurface
                )
            }

            Surface(
                shape = RoundedCornerShape(20.dp),
                color = MaterialTheme.colorScheme.surfaceVariant,
                modifier = Modifier.padding(horizontal = 4.dp)
            ) {
                Text(
                    text = "Soal ${state.currentIndex + 1} dari ${state.questions.size}",
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(horizontal = 14.dp, vertical = 6.dp)
                )
            }

            // Era Tag
            Surface(
                shape = RoundedCornerShape(20.dp),
                color = HistoricBronze.copy(alpha = 0.2f),
                modifier = Modifier.padding(end = 8.dp)
            ) {
                Text(
                    text = currentQuestion.era,
                    style = MaterialTheme.typography.labelMedium,
                    color = HistoricBronze,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp)
                )
            }
        }

        // Score & Streak Multiplier Row
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 4.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = "SKOR SAAT INI",
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Text(
                    text = "${state.score} Pts",
                    fontFamily = CinzelFontFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp,
                    color = HistoricGoldPrimary,
                    modifier = Modifier.testTag("current_score_text")
                )
            }

            if (state.streak >= 2) {
                Surface(
                    shape = RoundedCornerShape(12.dp),
                    color = HistoricGoldPrimary,
                    shadowElevation = 4.dp
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "🔥 COMBO x${state.streak}!",
                            fontWeight = FontWeight.Bold,
                            fontSize = 13.sp,
                            color = Color(0xFF14110E)
                        )
                    }
                }
            }
        }

        // Timer Progress Bar
        if (totalTime > 0) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 6.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.Timer,
                            contentDescription = null,
                            tint = timerColor,
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "Sisa Waktu",
                            style = MaterialTheme.typography.labelMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                    Text(
                        text = "${state.timeLeft} detik",
                        style = MaterialTheme.typography.labelLarge,
                        fontWeight = FontWeight.Bold,
                        color = timerColor
                    )
                }

                Spacer(modifier = Modifier.height(4.dp))

                LinearProgressIndicator(
                    progress = { animatedProgress },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(6.dp)
                        .clip(RoundedCornerShape(3.dp)),
                    color = timerColor,
                    trackColor = MaterialTheme.colorScheme.surfaceVariant,
                    strokeCap = StrokeCap.Round
                )
            }
        }

        // Lifelines Toolbar
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 4.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // 50:50 Lifeline
            AssistChip(
                onClick = { viewModel.useLifeline5050() },
                enabled = state.isLifeline5050Available && !state.isSubmitted,
                label = { Text("50:50") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Filter2,
                        contentDescription = null,
                        modifier = Modifier.size(16.dp)
                    )
                },
                colors = AssistChipDefaults.assistChipColors(
                    containerColor = if (state.isLifeline5050Available) MaterialTheme.colorScheme.surfaceVariant else Color.Transparent
                ),
                modifier = Modifier
                    .weight(1f)
                    .testTag("lifeline_5050_button")
            )

            // Hint Lifeline
            AssistChip(
                onClick = { viewModel.useLifelineHint() },
                enabled = state.isLifelineHintAvailable && !state.isSubmitted,
                label = { Text("Petunjuk") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Lightbulb,
                        contentDescription = null,
                        modifier = Modifier.size(16.dp)
                    )
                },
                colors = AssistChipDefaults.assistChipColors(
                    containerColor = if (state.isLifelineHintAvailable) MaterialTheme.colorScheme.surfaceVariant else Color.Transparent
                ),
                modifier = Modifier
                    .weight(1f)
                    .testTag("lifeline_hint_button")
            )

            // Skip Lifeline
            AssistChip(
                onClick = { viewModel.skipQuestion() },
                enabled = !state.isSubmitted,
                label = { Text("Lewati") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.SkipNext,
                        contentDescription = null,
                        modifier = Modifier.size(16.dp)
                    )
                },
                colors = AssistChipDefaults.assistChipColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant
                ),
                modifier = Modifier
                    .weight(1f)
                    .testTag("lifeline_skip_button")
            )
        }

        // Scrollable Question & Options
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
        ) {
            // Question Card
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 14.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    shape = RoundedCornerShape(16.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(18.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = currentQuestion.category.title.uppercase(),
                                style = MaterialTheme.typography.labelSmall,
                                fontWeight = FontWeight.Bold,
                                color = HistoricGoldPrimary,
                                letterSpacing = 1.sp
                            )

                            Surface(
                                shape = RoundedCornerShape(6.dp),
                                color = when (currentQuestion.difficulty) {
                                    Difficulty.EASY -> QuizCorrect.copy(alpha = 0.15f)
                                    Difficulty.MEDIUM -> HistoricGoldDark.copy(alpha = 0.2f)
                                    Difficulty.HARD -> QuizWrong.copy(alpha = 0.15f)
                                }
                            ) {
                                Text(
                                    text = currentQuestion.difficulty.label,
                                    style = MaterialTheme.typography.labelSmall,
                                    color = when (currentQuestion.difficulty) {
                                        Difficulty.EASY -> QuizCorrect
                                        Difficulty.MEDIUM -> HistoricGoldPrimary
                                        Difficulty.HARD -> QuizWrong
                                    },
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp)
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        Text(
                            text = currentQuestion.questionText,
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold,
                            lineHeight = 28.sp,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }
                }
            }

            // 4 Multiple Choice Options
            items(currentQuestion.options.size) { index ->
                val optionText = currentQuestion.options[index]
                val isEliminated = state.eliminatedOptions.contains(index)
                val isSelected = state.selectedOptionIndex == index
                val isCorrectAnswer = index == currentQuestion.correctAnswerIndex

                val optionLetter = when (index) {
                    0 -> "A"
                    1 -> "B"
                    2 -> "C"
                    else -> "D"
                }

                val (containerColor, borderColor, contentColor) = when {
                    state.isSubmitted && isCorrectAnswer -> Triple(
                        QuizCorrect.copy(alpha = 0.18f),
                        QuizCorrect,
                        MaterialTheme.colorScheme.onSurface
                    )
                    state.isSubmitted && isSelected && !isCorrectAnswer -> Triple(
                        QuizWrong.copy(alpha = 0.18f),
                        QuizWrong,
                        MaterialTheme.colorScheme.onSurface
                    )
                    isSelected -> Triple(
                        HistoricGoldDark.copy(alpha = 0.25f),
                        HistoricGoldPrimary,
                        MaterialTheme.colorScheme.onSurface
                    )
                    else -> Triple(
                        MaterialTheme.colorScheme.surfaceVariant,
                        Color.Transparent,
                        MaterialTheme.colorScheme.onSurface
                    )
                }

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 5.dp)
                        .alpha(if (isEliminated) 0.25f else 1f)
                        .clip(RoundedCornerShape(14.dp))
                        .clickable(enabled = !state.isSubmitted && !isEliminated) {
                            viewModel.selectOption(index)
                        }
                        .border(
                            width = if (borderColor != Color.Transparent) 2.dp else 1.dp,
                            color = if (borderColor != Color.Transparent) borderColor else MaterialTheme.colorScheme.outline.copy(alpha = 0.1f),
                            shape = RoundedCornerShape(14.dp)
                        )
                        .testTag("option_card_$index"),
                    colors = CardDefaults.cardColors(containerColor = containerColor)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(14.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Surface(
                            shape = CircleShape,
                            color = when {
                                state.isSubmitted && isCorrectAnswer -> QuizCorrect
                                state.isSubmitted && isSelected && !isCorrectAnswer -> QuizWrong
                                else -> HistoricGoldDark.copy(alpha = 0.4f)
                            },
                            modifier = Modifier.size(36.dp)
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                if (state.isSubmitted && isCorrectAnswer) {
                                    Icon(
                                        imageVector = Icons.Default.Check,
                                        contentDescription = "Jawaban Benar",
                                        tint = Color.White,
                                        modifier = Modifier.size(20.dp)
                                    )
                                } else if (state.isSubmitted && isSelected && !isCorrectAnswer) {
                                    Icon(
                                        imageVector = Icons.Default.Close,
                                        contentDescription = "Jawaban Salah",
                                        tint = Color.White,
                                        modifier = Modifier.size(20.dp)
                                    )
                                } else {
                                    Text(
                                        text = optionLetter,
                                        fontFamily = CinzelFontFamily,
                                        fontWeight = FontWeight.Bold,
                                        color = Color.White
                                    )
                                }
                            }
                        }

                        Spacer(modifier = Modifier.width(14.dp))

                        Text(
                            text = optionText,
                            style = MaterialTheme.typography.bodyLarge,
                            fontWeight = if (isSelected || (state.isSubmitted && isCorrectAnswer)) FontWeight.Bold else FontWeight.Normal,
                            color = contentColor,
                            modifier = Modifier.weight(1f)
                        )
                    }
                }
            }

            // Post-Answer Explanation Box
            item {
                AnimatedVisibility(
                    visible = state.isSubmitted,
                    enter = fadeIn() + slideInVertically()
                ) {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp, bottom = 8.dp)
                            .testTag("explanation_card"),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.surface
                        ),
                        shape = RoundedCornerShape(16.dp),
                        border = androidx.compose.foundation.BorderStroke(
                            1.dp,
                            if (state.lastAnswerCorrect == true) QuizCorrect else QuizWrong
                        )
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                Icon(
                                    imageVector = if (state.lastAnswerCorrect == true) Icons.Default.Check else Icons.Default.HelpOutline,
                                    contentDescription = null,
                                    tint = if (state.lastAnswerCorrect == true) QuizCorrect else QuizWrong,
                                    modifier = Modifier.size(22.dp)
                                )
                                Text(
                                    text = if (state.lastAnswerCorrect == true) "JAWABAN BENAR!" else "PEMBAHASAN SEJARAH",
                                    fontWeight = FontWeight.Bold,
                                    fontFamily = CinzelFontFamily,
                                    color = if (state.lastAnswerCorrect == true) QuizCorrect else QuizWrong,
                                    fontSize = 15.sp
                                )
                            }

                            Spacer(modifier = Modifier.height(8.dp))

                            Text(
                                text = currentQuestion.explanation,
                                style = MaterialTheme.typography.bodyMedium,
                                lineHeight = 22.sp,
                                color = MaterialTheme.colorScheme.onSurface
                            )

                            Spacer(modifier = Modifier.height(14.dp))

                            Button(
                                onClick = { viewModel.nextQuestion() },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(50.dp)
                                    .testTag("next_question_button"),
                                shape = RoundedCornerShape(12.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = HistoricGoldPrimary,
                                    contentColor = Color(0xFF14110E)
                                )
                            ) {
                                Text(
                                    text = if (state.currentIndex + 1 < state.questions.size) "Soal Berikutnya" else "Lihat Hasil Akhir",
                                    fontFamily = CinzelFontFamily,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 15.sp
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Icon(
                                    imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                                    contentDescription = null,
                                    modifier = Modifier.size(18.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    }

    // Hint Dialog
    if (state.showHintDialog) {
        AlertDialog(
            onDismissRequest = { viewModel.dismissHintDialog() },
            title = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.Lightbulb,
                        contentDescription = null,
                        tint = HistoricGoldPrimary
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Petunjuk Sejarah",
                        fontFamily = CinzelFontFamily,
                        fontWeight = FontWeight.Bold
                    )
                }
            },
            text = {
                Text(
                    text = state.activeHint,
                    style = MaterialTheme.typography.bodyLarge,
                    lineHeight = 24.sp
                )
            },
            confirmButton = {
                TextButton(
                    onClick = { viewModel.dismissHintDialog() },
                    modifier = Modifier.testTag("dismiss_hint_button")
                ) {
                    Text("Mengerti", color = HistoricGoldPrimary, fontWeight = FontWeight.Bold)
                }
            }
        )
    }

    // Quit Confirm Dialog
    if (state.showQuitConfirmDialog) {
        AlertDialog(
            onDismissRequest = { viewModel.showQuitDialog(false) },
            title = {
                Text(
                    text = "Tinggalkan Kuis?",
                    fontFamily = CinzelFontFamily,
                    fontWeight = FontWeight.Bold
                )
            },
            text = {
                Text("Progres dan skor kuis yang sedang berjalan ini akan hilang jika kamu kembali ke beranda.")
            },
            confirmButton = {
                Button(
                    onClick = { viewModel.quitQuizToHome() },
                    colors = ButtonDefaults.buttonColors(containerColor = QuizWrong),
                    modifier = Modifier.testTag("confirm_quit_button")
                ) {
                    Text("Ya, Keluar")
                }
            },
            dismissButton = {
                OutlinedButton(
                    onClick = { viewModel.showQuitDialog(false) },
                    modifier = Modifier.testTag("cancel_quit_button")
                ) {
                    Text("Lanjut Main")
                }
            }
        )
    }
}
