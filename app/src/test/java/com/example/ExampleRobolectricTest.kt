package com.example

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.example.data.HistoricalQuestions
import com.example.data.QuizRepository
import com.example.model.QuizCategory
import com.example.model.QuizMode
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [36])
class ExampleRobolectricTest {

    @Test
    fun `read string from context`() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val appName = context.getString(R.string.app_name)
        assertEquals("Kuis Sejarah", appName)
    }

    @Test
    fun `historical questions repository provides valid questions`() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val repository = QuizRepository(context)

        val questions = repository.getQuestionsForSession(QuizCategory.ALL, QuizMode.STANDARD)
        assertEquals(10, questions.size)

        questions.forEach { q ->
            assertEquals(4, q.options.size)
            assertTrue(q.correctAnswerIndex in 0..3)
            assertTrue(q.explanation.isNotEmpty())
        }
    }

    @Test
    fun `all categories have at least 5 questions`() {
        QuizCategory.values().forEach { category ->
            if (category != QuizCategory.ALL) {
                val questions = HistoricalQuestions.allQuestions.filter { it.category == category }
                assertTrue(
                    "Kategori ${category.title} harus memiliki minimal 5 soal, saat ini: ${questions.size}",
                    questions.size >= 5
                )
            }
        }
    }
}
