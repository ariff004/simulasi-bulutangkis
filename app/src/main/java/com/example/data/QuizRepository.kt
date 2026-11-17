package com.example.data

import android.content.Context
import com.example.model.HighScoreRecord
import com.example.model.Question
import com.example.model.QuizCategory
import com.example.model.QuizMode
import org.json.JSONArray
import org.json.JSONObject
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class QuizRepository(private val context: Context) {

    private val prefs = context.getSharedPreferences("history_quiz_prefs", Context.MODE_PRIVATE)

    fun getQuestionsForSession(category: QuizCategory, mode: QuizMode): List<Question> {
        val filtered = if (category == QuizCategory.ALL) {
            HistoricalQuestions.allQuestions
        } else {
            HistoricalQuestions.allQuestions.filter { it.category == category }
        }

        // Shuffle questions and randomize options order
        val count = mode.questionCount.coerceAtMost(filtered.size)
        val selected = filtered.shuffled().take(count)

        return selected.map { q ->
            val correctOptionText = q.options[q.correctAnswerIndex]
            val shuffledOptions = q.options.shuffled()
            val newCorrectIndex = shuffledOptions.indexOf(correctOptionText)

            q.copy(
                options = shuffledOptions,
                correctAnswerIndex = newCorrectIndex
            )
        }
    }

    fun getHighScores(): List<HighScoreRecord> {
        val rawJson = prefs.getString("high_scores", null) ?: return getInitialHighScores()
        val list = mutableListOf<HighScoreRecord>()
        try {
            val array = JSONArray(rawJson)
            for (i in 0 until array.length()) {
                val obj = array.getJSONObject(i)
                list.add(
                    HighScoreRecord(
                        id = obj.optLong("id", System.currentTimeMillis()),
                        playerName = obj.optString("playerName", "Pemain"),
                        score = obj.optInt("score", 0),
                        categoryTitle = obj.optString("categoryTitle", "Semua"),
                        modeTitle = obj.optString("modeTitle", "Standar"),
                        accuracy = obj.optInt("accuracy", 0),
                        dateString = obj.optString("dateString", "Hari ini")
                    )
                )
            }
        } catch (_: Exception) {
            return getInitialHighScores()
        }
        return list.sortedByDescending { it.score }
    }

    fun saveHighScore(
        playerName: String,
        score: Int,
        category: QuizCategory,
        mode: QuizMode,
        accuracy: Int
    ) {
        val currentList = getHighScores().toMutableList()
        val dateFormat = SimpleDateFormat("dd MMM yyyy", Locale("id", "ID"))
        val dateStr = dateFormat.format(Date())

        val cleanName = playerName.trim().ifEmpty { "Sejarawan Tamu" }

        val newRecord = HighScoreRecord(
            id = System.currentTimeMillis(),
            playerName = cleanName,
            score = score,
            categoryTitle = category.title,
            modeTitle = mode.title,
            accuracy = accuracy,
            dateString = dateStr
        )

        currentList.add(newRecord)
        val topList = currentList.sortedByDescending { it.score }.take(15)

        val array = JSONArray()
        topList.forEach { rec ->
            val obj = JSONObject()
            obj.put("id", rec.id)
            obj.put("playerName", rec.playerName)
            obj.put("score", rec.score)
            obj.put("categoryTitle", rec.categoryTitle)
            obj.put("modeTitle", rec.modeTitle)
            obj.put("accuracy", rec.accuracy)
            obj.put("dateString", rec.dateString)
            array.put(obj)
        }

        prefs.edit().putString("high_scores", array.toString()).apply()

        // Update overall stats
        val totalGames = prefs.getInt("total_games", 0) + 1
        val allTimeHighScore = prefs.getInt("all_time_high_score", 0)
        prefs.edit()
            .putInt("total_games", totalGames)
            .putInt("all_time_high_score", maxOf(allTimeHighScore, score))
            .apply()
    }

    fun getBestOverallScore(): Int {
        return prefs.getInt("all_time_high_score", 1250)
    }

    fun getTotalGamesPlayed(): Int {
        return prefs.getInt("total_games", 0)
    }

    fun clearHighScores() {
        prefs.edit().remove("high_scores").apply()
    }

    private fun getInitialHighScores(): List<HighScoreRecord> {
        return listOf(
            HighScoreRecord(
                id = 1L,
                playerName = "Gajah Mada",
                score = 1580,
                categoryTitle = "Semua Topik",
                modeTitle = "Mode Standar",
                accuracy = 100,
                dateString = "Rekor Legenda"
            ),
            HighScoreRecord(
                id = 2L,
                playerName = "Soekarno Muda",
                score = 1420,
                categoryTitle = "Kemerdekaan RI",
                modeTitle = "Mode Standar",
                accuracy = 95,
                dateString = "Rekor Legenda"
            ),
            HighScoreRecord(
                id = 3L,
                playerName = "Ibnu Khaldun",
                score = 1290,
                categoryTitle = "Peradaban Dunia",
                modeTitle = "Mode Cepat",
                accuracy = 90,
                dateString = "Rekor Legenda"
            )
        )
    }
}
