package com.example.model

enum class QuizCategory(val id: String, val title: String, val subtitle: String) {
    ALL("all", "Semua Topik", "Koleksi lengkap sejarah Indonesia & peradaban dunia"),
    KEMERDEKAAN("kemerdekaan", "Kemerdekaan RI", "Peristiwa Proklamasi, BPUPKI, dan tokoh pahlawan"),
    KERAJAAN("kerajaan", "Kerajaan Nusantara", "Majapahit, Sriwijaya, Mataram Kuno, dan Kutai"),
    DUNIA("dunia", "Peradaban Kuno", "Mesir Kuno, Yunani, Romawi, dan Mesopotamia"),
    PERANG_DIPLOMASI("perang", "Perang & Diplomasi", "Perang Dunia I & II, KAA Bandung, dan PBB"),
    TOKOH_DUNIA("tokoh", "Tokoh & Revolusi", "Revolusi Prancis, Amerika, Tokoh Penemu & Pemikir"),
    SAINS_PENEMUAN("sains", "Penemuan & Sains Sejarah", "Revolusi Industri, Penjelajahan Samudra & Kompas"),
    SEJARAH_ISLAM("islam", "Peradaban Islam", "Baitul Hikmah, Kekhalifahan Abbasiyah, Andalusia & Jalur Sutra")
}

enum class Difficulty(val label: String, val basePoints: Int) {
    EASY("Mudah", 100),
    MEDIUM("Sedang", 150),
    HARD("Tantangan", 200)
}

enum class QuizMode(val title: String, val questionCount: Int, val timePerQuestionSec: Int, val description: String) {
    STANDARD("Mode Standar", 10, 20, "10 Soal • Timer 20 detik • Sistem Skor & Combo"),
    BLITZ("Mode Cepat", 15, 12, "15 Soal • Timer 12 detik • Bonus Kecepatan Tinggi"),
    RELAX("Mode Santai", 10, 0, "10 Soal • Tanpa Batas Waktu • Pelajari Pembahasan")
}

data class Question(
    val id: Int,
    val questionText: String,
    val options: List<String>,
    val correctAnswerIndex: Int,
    val explanation: String,
    val category: QuizCategory,
    val difficulty: Difficulty = Difficulty.MEDIUM,
    val era: String = "Sejarah Umum",
    val hint: String = ""
)

data class QuestionReview(
    val question: Question,
    val selectedOptionIndex: Int?,
    val isCorrect: Boolean,
    val isTimedOut: Boolean,
    val pointsEarned: Int
)

data class QuizResult(
    val finalScore: Int,
    val correctCount: Int,
    val wrongCount: Int,
    val totalQuestions: Int,
    val maxStreak: Int,
    val accuracyPercent: Int,
    val rankTitle: String,
    val rankBadge: String,
    val reviews: List<QuestionReview>,
    val category: QuizCategory,
    val mode: QuizMode
)

data class HighScoreRecord(
    val id: Long = System.currentTimeMillis(),
    val playerName: String,
    val score: Int,
    val categoryTitle: String,
    val modeTitle: String,
    val accuracy: Int,
    val dateString: String
)
