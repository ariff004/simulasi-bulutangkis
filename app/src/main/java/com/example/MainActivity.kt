package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ui.HomeScreen
import com.example.ui.LeaderboardScreen
import com.example.ui.QuizScreen
import com.example.ui.ResultScreen
import com.example.ui.TriviaScreen
import com.example.ui.theme.MyApplicationTheme
import com.example.viewmodel.QuizViewModel
import com.example.viewmodel.ScreenState

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    QuizAppRoot()
                }
            }
        }
    }
}

@Composable
fun QuizAppRoot(
    viewModel: QuizViewModel = viewModel()
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()

    when (state.currentScreen) {
        ScreenState.HOME -> {
            HomeScreen(
                state = state,
                onCategorySelected = { viewModel.selectCategory(it) },
                onModeSelected = { viewModel.selectMode(it) },
                onStartQuiz = { viewModel.startQuiz() },
                onNavigate = { viewModel.navigateTo(it) }
            )
        }
        ScreenState.QUIZ -> {
            QuizScreen(
                state = state,
                viewModel = viewModel
            )
        }
        ScreenState.RESULT -> {
            ResultScreen(
                state = state,
                viewModel = viewModel
            )
        }
        ScreenState.LEADERBOARD -> {
            LeaderboardScreen(
                state = state,
                viewModel = viewModel
            )
        }
        ScreenState.TRIVIA -> {
            TriviaScreen(
                viewModel = viewModel
            )
        }
    }
}
