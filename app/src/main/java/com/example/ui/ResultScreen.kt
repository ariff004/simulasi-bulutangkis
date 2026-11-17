package com.example.ui

import android.content.Intent
import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
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
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Replay
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.theme.CinzelFontFamily
import com.example.ui.theme.HistoricBronze
import com.example.ui.theme.HistoricGoldDark
import com.example.ui.theme.HistoricGoldPrimary
import com.example.ui.theme.QuizCorrect
import com.example.ui.theme.QuizWrong
import com.example.viewmodel.QuizUiState
import com.example.viewmodel.QuizViewModel
import com.example.viewmodel.ScreenState

@Composable
fun ResultScreen(
    state: QuizUiState,
    viewModel: QuizViewModel
) {
    val context = LocalContext.current
    val result = state.quizResult ?: return

    BackHandler {
        viewModel.navigateTo(ScreenState.HOME)
    }

    var isReviewExpanded by remember { mutableStateOf(false) }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .navigationBarsPadding()
            .testTag("result_screen"),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 20.dp)
    ) {
        // Header Rank & Badge
        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Surface(
                    shape = CircleShape,
                    color = HistoricGoldDark.copy(alpha = 0.2f),
                    modifier = Modifier.size(80.dp)
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Text(
                            text = result.rankBadge,
                            fontSize = 42.sp
                        )
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = result.rankTitle,
                    fontFamily = CinzelFontFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 26.sp,
                    color = HistoricGoldPrimary,
                    textAlign = TextAlign.Center
                )

                Text(
                    text = "${result.category.title} • ${result.mode.title}",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }

        // Score Card
        item {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                shape = RoundedCornerShape(20.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "TOTAL SKOR AKHIR",
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        letterSpacing = 1.sp
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    Text(
                        text = "${result.finalScore}",
                        fontFamily = CinzelFontFamily,
                        fontWeight = FontWeight.Bold,
                        fontSize = 48.sp,
                        color = HistoricGoldPrimary
                    )

                    Spacer(modifier = Modifier.height(18.dp))

                    // Grid of 4 stats
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        StatItem(
                            label = "Benar",
                            value = "${result.correctCount}/${result.totalQuestions}",
                            color = QuizCorrect
                        )
                        StatItem(
                            label = "Salah",
                            value = "${result.wrongCount}",
                            color = QuizWrong
                        )
                        StatItem(
                            label = "Akurasi",
                            value = "${result.accuracyPercent}%",
                            color = HistoricGoldPrimary
                        )
                        StatItem(
                            label = "Max Combo",
                            value = "${result.maxStreak}x",
                            color = HistoricBronze
                        )
                    }
                }
            }
        }

        // Save to High Scores Card
        item {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
                shape = RoundedCornerShape(16.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.EmojiEvents,
                            contentDescription = null,
                            tint = HistoricGoldPrimary,
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = if (state.isScoreSaved) "Skor Berhasil Disimpan!" else "Catat Rekor Sejarahmu",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    if (!state.isScoreSaved) {
                        OutlinedTextField(
                            value = state.playerNameInput,
                            onValueChange = { viewModel.updatePlayerName(it) },
                            placeholder = { Text("Masukkan namamu (cth: Raden Wijaya)") },
                            modifier = Modifier
                                .fillMaxWidth()
                                .testTag("player_name_input"),
                            singleLine = true,
                            shape = RoundedCornerShape(12.dp)
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        Button(
                            onClick = { viewModel.saveScoreToLeaderboard() },
                            modifier = Modifier
                                .fillMaxWidth()
                                .testTag("save_score_button"),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = HistoricGoldPrimary,
                                contentColor = Color(0xFF14110E)
                            ),
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            Text("Simpan ke Papan Skor", fontWeight = FontWeight.Bold)
                        }
                    } else {
                        Text(
                            text = "Rekor Anda dengan nama '${state.playerNameInput.ifEmpty { "Sejarawan Tamu" }}' telah diabadikan di Papan Skor!",
                            style = MaterialTheme.typography.bodyMedium,
                            color = QuizCorrect
                        )
                    }
                }
            }
        }

        // Primary Action Buttons (Play Again, Home, Share)
        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Button(
                    onClick = { viewModel.startQuiz() },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(52.dp)
                        .testTag("play_again_button"),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = HistoricGoldPrimary,
                        contentColor = Color(0xFF14110E)
                    ),
                    shape = RoundedCornerShape(14.dp)
                ) {
                    Icon(imageVector = Icons.Default.Replay, contentDescription = null)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Main Lagi",
                        fontFamily = CinzelFontFamily,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    OutlinedButton(
                        onClick = { viewModel.navigateTo(ScreenState.HOME) },
                        modifier = Modifier
                            .weight(1f)
                            .height(50.dp)
                            .testTag("back_to_home_button"),
                        shape = RoundedCornerShape(14.dp)
                    ) {
                        Icon(imageVector = Icons.Default.Home, contentDescription = null)
                        Spacer(modifier = Modifier.width(6.dp))
                        Text("Beranda")
                    }

                    OutlinedButton(
                        onClick = {
                            val shareIntent = Intent(Intent.ACTION_SEND).apply {
                                type = "text/plain"
                                putExtra(
                                    Intent.EXTRA_TEXT,
                                    "🏛️ Aku meraih skor ${result.finalScore} poin (${result.accuracyPercent}% akurasi) dengan gelar '${result.rankTitle}' di Kuis Sejarah! Ayo uji wawasan sejarahmu juga!"
                                )
                            }
                            context.startActivity(Intent.createChooser(shareIntent, "Bagikan Skor Kuis"))
                        },
                        modifier = Modifier
                            .weight(1f)
                            .height(50.dp)
                            .testTag("share_score_button"),
                        shape = RoundedCornerShape(14.dp)
                    ) {
                        Icon(imageVector = Icons.Default.Share, contentDescription = null)
                        Spacer(modifier = Modifier.width(6.dp))
                        Text("Bagikan")
                    }
                }
            }
        }

        // Expandable Review Section
        item {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
                    .clip(RoundedCornerShape(14.dp))
                    .clickable { isReviewExpanded = !isReviewExpanded }
                    .testTag("toggle_review_button"),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Tinjau Semua Pembahasan Soal (${result.reviews.size})",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Icon(
                        imageVector = if (isReviewExpanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
                        contentDescription = null
                    )
                }
            }
        }

        if (isReviewExpanded) {
            itemsIndexed(result.reviews) { idx, review ->
                val q = review.question
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
                    shape = RoundedCornerShape(14.dp)
                ) {
                    Column(modifier = Modifier.padding(14.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Surface(
                                shape = CircleShape,
                                color = if (review.isCorrect) QuizCorrect else QuizWrong,
                                modifier = Modifier.size(24.dp)
                            ) {
                                Box(contentAlignment = Alignment.Center) {
                                    Icon(
                                        imageVector = if (review.isCorrect) Icons.Default.Check else Icons.Default.Close,
                                        contentDescription = null,
                                        tint = Color.White,
                                        modifier = Modifier.size(16.dp)
                                    )
                                }
                            }
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "Soal ${idx + 1}",
                                style = MaterialTheme.typography.labelLarge,
                                fontWeight = FontWeight.Bold,
                                color = if (review.isCorrect) QuizCorrect else QuizWrong
                            )
                            Spacer(modifier = Modifier.weight(1f))
                            Text(
                                text = if (review.isCorrect) "+${review.pointsEarned} Pts" else "0 Pts",
                                style = MaterialTheme.typography.labelMedium,
                                fontWeight = FontWeight.Bold,
                                color = if (review.isCorrect) HistoricGoldPrimary else MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }

                        Spacer(modifier = Modifier.height(6.dp))

                        Text(
                            text = q.questionText,
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(modifier = Modifier.height(6.dp))

                        if (review.selectedOptionIndex != null) {
                            Text(
                                text = "Jawabanmu: ${q.options[review.selectedOptionIndex]}",
                                style = MaterialTheme.typography.bodySmall,
                                color = if (review.isCorrect) QuizCorrect else QuizWrong
                            )
                        } else {
                            Text(
                                text = if (review.isTimedOut) "Jawabanmu: Waktu Habis" else "Jawabanmu: Dilewati",
                                style = MaterialTheme.typography.bodySmall,
                                color = QuizWrong
                            )
                        }

                        if (!review.isCorrect) {
                            Text(
                                text = "Jawaban Benar: ${q.options[q.correctAnswerIndex]}",
                                style = MaterialTheme.typography.bodySmall,
                                fontWeight = FontWeight.Bold,
                                color = QuizCorrect
                            )
                        }

                        Spacer(modifier = Modifier.height(6.dp))

                        Text(
                            text = "💡 ${q.explanation}",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            lineHeight = 18.sp
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun StatItem(label: String, value: String, color: Color) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = value,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            color = color
        )
        Text(
            text = label,
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}
