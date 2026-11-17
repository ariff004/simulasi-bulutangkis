package com.example.data

import com.example.model.Difficulty
import com.example.model.Question
import com.example.model.QuizCategory

object HistoricalQuestions {

    val allQuestions: List<Question> = listOf(
        // ==========================================
        // 1. KEMERDEKAAN RI
        // ==========================================
        Question(
            id = 1,
            questionText = "Siapakah tokoh yang mengetik naskah asli Proklamasi Kemerdekaan Indonesia pada tahun 1945?",
            options = listOf("Sayuti Melik", "Sukarni", "B.M. Diah", "Achmad Soebardjo"),
            correctAnswerIndex = 0,
            explanation = "Sayuti Melik mengetik naskah Proklamasi Kemerdekaan Indonesia dengan beberapa perubahan kecil dari konsep tulisan tangan Ir. Soekarno.",
            category = QuizCategory.KEMERDEKAAN,
            difficulty = Difficulty.EASY,
            era = "Agustus 1945",
            hint = "Ia adalah suami dari S.K. Trimurti dan anggota PPKI."
        ),
        Question(
            id = 2,
            questionText = "Di manakah lokasi pembacaan teks Proklamasi Kemerdekaan Indonesia pada 17 Agustus 1945?",
            options = listOf(
                "Jl. Pegangsaan Timur No. 56, Jakarta",
                "Gedung Merdeka, Bandung",
                "Jl. Menteng Raya No. 31, Jakarta",
                "Gedung Volksraad, Jakarta"
            ),
            correctAnswerIndex = 0,
            explanation = "Teks Proklamasi dibacakan di kediaman Bung Karno di Jalan Pegangsaan Timur No. 56, Jakarta Pusat (kini Gedung Pola / Tugu Proklamasi).",
            category = QuizCategory.KEMERDEKAAN,
            difficulty = Difficulty.EASY,
            era = "Agustus 1945",
            hint = "Rumah kediaman Bung Karno di Jakarta Pusat."
        ),
        Question(
            id = 3,
            questionText = "Peristiwa pengasingan Bung Karno dan Bung Hatta oleh golongan muda menjelang kemerdekaan dikenal dengan peristiwa apa?",
            options = listOf(
                "Peristiwa Rengasdengklok",
                "Peristiwa Bandung Lautan Api",
                "Insiden Hotel Yamato",
                "Palagan Ambarawa"
            ),
            correctAnswerIndex = 0,
            explanation = "Peristiwa Rengasdengklok terjadi pada 16 Agustus 1945 di Karawang, di mana para pemuda mendesak Soekarno dan Hatta segera memproklamasikan kemerdekaan tanpa pengaruh Jepang.",
            category = QuizCategory.KEMERDEKAAN,
            difficulty = Difficulty.EASY,
            era = "Agustus 1945",
            hint = "Terjadi di sebuah kota kecil dekat Karawang, Jawa Barat."
        ),
        Question(
            id = 4,
            questionText = "Siapakah yang menjahit Bendera Pusaka Sang Saka Merah Putih yang dikibarkan saat Proklamasi?",
            options = listOf("Fatmawati", "R.A. Kartini", "Dewi Sartika", "Cut Nyak Dien"),
            correctAnswerIndex = 0,
            explanation = "Ibu Fatmawati, istri dari Presiden Soekarno, menjahit bendera merah putih berbahan katun Jepang pada tahun 1944.",
            category = QuizCategory.KEMERDEKAAN,
            difficulty = Difficulty.EASY,
            era = "Tahun 1944-1945",
            hint = "Ibu negara pertama Republik Indonesia."
        ),
        Question(
            id = 5,
            questionText = "Peristiwa 'Bandung Lautan Api' pada 23 Maret 1946 dipicu oleh tindakan pembumihangusan kota Bandung demi tujuan apa?",
            options = listOf(
                "Mencegah Sekutu dan NICA menggunakan Bandung sebagai markas militer",
                "Merayakan kemenangan pejuang lokal",
                "Menyerahkan kekuasaan pada militer Jepang",
                "Membangun kota baru di wilayah Priangan"
            ),
            correctAnswerIndex = 0,
            explanation = "Para pejuang dan rakyat Bandung membakar rumah serta bangunan penting agar Sekutu dan NICA tidak dapat memanfaatkannya sebagai pos pertahanan militer strategis.",
            category = QuizCategory.KEMERDEKAAN,
            difficulty = Difficulty.MEDIUM,
            era = "Maret 1946",
            hint = "Taktik perang bumi hangus agar fasilitas vital tidak direbut musuh."
        ),
        Question(
            id = 6,
            questionText = "Hari Pahlawan pada 10 November diperingati untuk mengenang pertempuran heroik rakyat Indonesia melawan tentara Sekutu di kota mana?",
            options = listOf("Surabaya", "Semarang", "Yogyakarta", "Medan"),
            correctAnswerIndex = 0,
            explanation = "Pertempuran Surabaya mencapai puncaknya pada 10 November 1945, diawali tewasnya Brigadir Jenderal Mallaby dan kobaran semangat Bung Tomo melalui radio.",
            category = QuizCategory.KEMERDEKAAN,
            difficulty = Difficulty.EASY,
            era = "November 1945",
            hint = "Dikenal dengan julukan Kota Pahlawan."
        ),
        Question(
            id = 7,
            questionText = "Perjanjian resmi yang mengantarkan pengakuan kedaulatan Indonesia oleh Belanda pada tahun 1949 adalah?",
            options = listOf(
                "Konferensi Meja Bundar (KMB)",
                "Perjanjian Linggarjati",
                "Perjanjian Renville",
                "Perjanjian Roem-Royen"
            ),
            correctAnswerIndex = 0,
            explanation = "KMB diselenggarakan di Den Haag Belanda dari 23 Agustus hingga 2 November 1949, menghasilkan kesepakatan pengakuan kedaulatan Indonesia.",
            category = QuizCategory.KEMERDEKAAN,
            difficulty = Difficulty.MEDIUM,
            era = "Tahun 1949",
            hint = "Konferensi yang berlangsung di Den Haag dengan bentuk meja bundar."
        ),
        Question(
            id = 8,
            questionText = "Kongres Pemuda II yang melahirkan ikrar monumental 'Sumpah Pemuda' berlangsung pada tanggal berapa?",
            options = listOf(
                "28 Oktober 1928",
                "2 Mei 1928",
                "20 Mei 1908",
                "10 November 1928"
            ),
            correctAnswerIndex = 0,
            explanation = "Sumpah Pemuda diikrarkan pada 28 Oktober 1928 di Batavia (Jakarta), menegaskan satu tanah air, satu bangsa, dan satu bahasa persatuan Indonesia.",
            category = QuizCategory.KEMERDEKAAN,
            difficulty = Difficulty.EASY,
            era = "Oktober 1928",
            hint = "Bulan kesepuluh, diperingati setiap tahun sebagai Hari Sumpah Pemuda."
        ),
        Question(
            id = 9,
            questionText = "Siapakah panglima besar yang memimpin perang gerilya melawan agresi Belanda meski dalam kondisi ditandu sakit paru-paru?",
            options = listOf(
                "Jenderal Soedirman",
                "Jenderal Ahmad Yani",
                "Letjen Urip Sumohardjo",
                "Kolonel TB Simatupang"
            ),
            correctAnswerIndex = 0,
            explanation = "Jenderal Besar Soedirman memimpin perang gerilya selama tujuh bulan melintasi hutan dan gunung Jawa dalam kondisi menderita sakit TBC.",
            category = QuizCategory.KEMERDEKAAN,
            difficulty = Difficulty.EASY,
            era = "Agresi Militer Belanda II",
            hint = "Panglima pertama Tentara Nasional Indonesia (TNI)."
        ),
        Question(
            id = 10,
            questionText = "Organisasi pergerakan nasional pertama di Indonesia yang didirikan oleh dr. Soetomo pada 20 Mei 1908 adalah?",
            options = listOf("Budi Utomo", "Sarekat Islam", "Indische Partij", "Perhimpunan Indonesia"),
            correctAnswerIndex = 0,
            explanation = "Budi Utomo didirikan pada 20 Mei 1908 oleh para mahasiswa STOVIA. Hari berdirinya kini diperingati sebagai Hari Kebangkitan Nasional.",
            category = QuizCategory.KEMERDEKAAN,
            difficulty = Difficulty.EASY,
            era = "Mei 1908",
            hint = "Kini tanggal berdirinya diperingati sebagai Hari Kebangkitan Nasional."
        ),
        Question(
            id = 11,
            questionText = "Siapakah tokoh perempuan pejuang asal Jepara yang memperjuangkan emansipasi wanita melalui surat-suratnya yang dibukukan dalam 'Habis Gelap Terbitlah Terang'?",
            options = listOf("R.A. Kartini", "Dewi Sartika", "Cut Nyak Dien", "Maria Walanda Maramis"),
            correctAnswerIndex = 0,
            explanation = "Raden Ajeng Kartini menuliskan pemikiran kritisnya mengenai kesetaraan pendidikan bagi perempuan Jawa kepada sahabat-sahabat penanya di Belanda.",
            category = QuizCategory.KEMERDEKAAN,
            difficulty = Difficulty.EASY,
            era = "Abad ke-19 s.d awal abad 20",
            hint = "Diperingati setiap tanggal 21 April di Indonesia."
        ),

        // ==========================================
        // 2. KERAJAAN NUSANTARA
        // ==========================================
        Question(
            id = 12,
            questionText = "Kerajaan Hindu tertua di kepulauan Nusantara yang dibuktikan dengan penemuan 7 prasasti Yupa adalah kerajaan?",
            options = listOf("Kutai Martapura", "Tarumanegara", "Sriwijaya", "Kalingga"),
            correctAnswerIndex = 0,
            explanation = "Kerajaan Kutai di Kalimantan Timur diperkirakan berdiri sekitar abad ke-4 Masehi dengan raja terkenal bernama Mulawarman.",
            category = QuizCategory.KERAJAAN,
            difficulty = Difficulty.EASY,
            era = "Abad ke-4 Masehi",
            hint = "Berada di hulu Sungai Mahakam, Kalimantan Timur."
        ),
        Question(
            id = 13,
            questionText = "Mahapatih Gajah Mada dari Kerajaan Majapahit mengucapkan sumpah legendaris untuk menyatukan Nusantara yang bernama?",
            options = listOf("Sumpah Palapa", "Prasasti Canggal", "Kakawin Bharatayuddha", "Sumpah Amukti"),
            correctAnswerIndex = 0,
            explanation = "Sumpah Palapa diucapkan Gajah Mada saat upacara pengangkatannya menjadi Mahapatih Amangkubumi Majapahit pada tahun 1336 M.",
            category = QuizCategory.KERAJAAN,
            difficulty = Difficulty.EASY,
            era = "Kerajaan Majapahit (1336 M)",
            hint = "Bersumpah tidak akan menikmati kenikmatan duniawi sebelum menundukkan Nusantara."
        ),
        Question(
            id = 14,
            questionText = "Candi Borobudur dibangun pada masa pemerintahan Dinasti Syailendra yang menganut agama?",
            options = listOf("Buddha Mahayana", "Hindu Siwa", "Buddha Theravada", "Animisme"),
            correctAnswerIndex = 0,
            explanation = "Candi Borobudur didirikan sekitar abad ke-8 dan ke-9 Masehi oleh Dinasti Syailendra yang menganut mazhab Buddha Mahayana.",
            category = QuizCategory.KERAJAAN,
            difficulty = Difficulty.MEDIUM,
            era = "Abad ke-8 Masehi",
            hint = "Merupakan monumen dan candi peninggalan agama Buddha terbesar di dunia."
        ),
        Question(
            id = 15,
            questionText = "Kerajaan maritim Sriwijaya yang berpusat di Pulau Sumatra sangat tersohor di dunia internasional sebagai pusat apa?",
            options = listOf(
                "Perdagangan laut dan pembelajaran agama Buddha",
                "Pusat kerajinan perak dan besi",
                "Lumbung padi utama Asia Tenggara",
                "Pusat penyebaran ajaran Konfusianisme"
            ),
            correctAnswerIndex = 0,
            explanation = "Sriwijaya menguasai Selat Malaka dan Selat Sunda serta menjadi pusat pembelajaran bahasa Sanskerta dan ajaran Buddha bagi para biksu Asia.",
            category = QuizCategory.KERAJAAN,
            difficulty = Difficulty.MEDIUM,
            era = "Abad ke-7 s.d 11 Masehi",
            hint = "Dikenal sebagai kerajaan bahari / thalassocracy terkuat di Selat Malaka."
        ),
        Question(
            id = 16,
            questionText = "Pahlawan nasional sekaligus Sultan dari Kerajaan Gowa yang dijuluki 'Ayam Jantan dari Timur' (De Haantjes van Het Oosten) oleh Belanda adalah?",
            options = listOf(
                "Sultan Hasanuddin",
                "Sultan Baabullah",
                "Pangeran Antasari",
                "Pattimura"
            ),
            correctAnswerIndex = 0,
            explanation = "Sultan Hasanuddin memerintah Kerajaan Gowa-Tallo di Sulawesi Selatan dan gigih melawan monopoli dagang VOC Belanda.",
            category = QuizCategory.KERAJAAN,
            difficulty = Difficulty.EASY,
            era = "Abad ke-17 Masehi",
            hint = "Namanya kini diabadikan sebagai nama universitas dan bandara internasional di Makassar."
        ),
        Question(
            id = 17,
            questionText = "Siapakah raja Kerajaan Majapahit yang didampingi oleh Mahapatih Gajah Mada hingga mencapai puncak kejayaannya?",
            options = listOf("Hayam Wuruk", "Raden Wijaya", "Jayanegara", "Tribhuwana Tunggadewi"),
            correctAnswerIndex = 0,
            explanation = "Raja Hayam Wuruk bergelar Sri Rajasanagara memimpin Majapahit dari tahun 1350 hingga 1389 M bersama Mahapatih Gajah Mada.",
            category = QuizCategory.KERAJAAN,
            difficulty = Difficulty.MEDIUM,
            era = "Abad ke-14 Masehi",
            hint = "Cucu pendiri Majapahit yang naik tahta pada usia 16 tahun."
        ),
        Question(
            id = 18,
            questionText = "Kitab legendaris peninggalan Majapahit gubahan Mpu Tantular yang memuat semboyan 'Bhinneka Tunggal Ika' adalah?",
            options = listOf("Kitab Sutasoma", "Kitab Negarakertagama", "Kitab Pararaton", "Kitab Arjunawiwaha"),
            correctAnswerIndex = 0,
            explanation = "Semboyan 'Bhinneka Tunggal Ika Tan Hana Dharma Mangrwa' tercantum pada pupuh 139 bait 5 Kitab Sutasoma karya Mpu Tantular.",
            category = QuizCategory.KERAJAAN,
            difficulty = Difficulty.MEDIUM,
            era = "Abad ke-14 Masehi",
            hint = "Karya sastra kakawin yang mengisahkan Pangeran Sutasoma."
        ),
        Question(
            id = 19,
            questionText = "Kerajaan Islam pertama yang tercatat berdiri di wilayah kepulauan Nusantara adalah?",
            options = listOf("Samudera Pasai", "Kesultanan Demak", "Kesultanan Aceh", "Kesultanan Banten"),
            correctAnswerIndex = 0,
            explanation = "Kesultanan Samudera Pasai didirikan pada abad ke-13 oleh Meurah Silu (Sultan Malik as-Saleh) di pantai utara Sumatra (Aceh).",
            category = QuizCategory.KERAJAAN,
            difficulty = Difficulty.EASY,
            era = "Abad ke-13 Masehi",
            hint = "Berada di pesisir utara Lhokseumawe, Aceh."
        ),
        Question(
            id = 20,
            questionText = "Kompleks candi Hindu terbesar di Indonesia yang dipersembahkan untuk Trimurti (Brahma, Siwa, dan Wisnu) adalah?",
            options = listOf("Candi Prambanan", "Candi Mendut", "Candi Penataran", "Candi Sukuh"),
            correctAnswerIndex = 0,
            explanation = "Candi Prambanan (Roro Jonggrang) dibangun sekitar abad ke-9 Masehi oleh Rakai Pikatan dari Mataram Kuno sebagai persembahan untuk Dewa Siwa.",
            category = QuizCategory.KERAJAAN,
            difficulty = Difficulty.EASY,
            era = "Abad ke-9 Masehi",
            hint = "Terletak di perbatasan Klaten dan Sleman Yogyakarta."
        ),

        // ==========================================
        // 3. PERADABAN KUNO DUNIA
        // ==========================================
        Question(
            id = 21,
            questionText = "Peradaban Mesir Kuno berkembang subur karena anugerah aliran air dari sungai terpanjang di benua Afrika yaitu?",
            options = listOf("Sungai Nil", "Sungai Amazon", "Sungai Tigris", "Sungai Eufrat"),
            correctAnswerIndex = 0,
            explanation = "Sungai Nil dijuluki 'Nadi Kehidupan Mesir' karena banjir tahunannya membawa endapan lumpur hitam subur yang memungkinkan berkembangnya peradaban agraris kuno.",
            category = QuizCategory.DUNIA,
            difficulty = Difficulty.EASY,
            era = "Zaman Kuno",
            hint = "Sungai yang mengalir melintasi piramida-piramida di Mesir."
        ),
        Question(
            id = 22,
            questionText = "Sistem pemerintahan 'Demokrasi' pertama kali lahir dan diterapkan di negara-kota (polis) mana pada zaman kuno?",
            options = listOf("Athena (Yunani Kuno)", "Roma (Romawi)", "Sparta (Yunani Kuno)", "Babilonia"),
            correctAnswerIndex = 0,
            explanation = "Demokrasi langsung dicetuskan di polis Athena pada sekitar abad ke-5 SM di bawah kepemimpinan tokoh pembaru seperti Kleisthenes dan Perikles.",
            category = QuizCategory.DUNIA,
            difficulty = Difficulty.EASY,
            era = "Abad ke-5 Sebelum Masehi",
            hint = "Ibu kota modern Yunani saat ini."
        ),
        Question(
            id = 23,
            questionText = "Kode hukum tertulis pertama di dunia yang terkenal dengan prinsip 'Mata ganti mata, gigi ganti gigi' berasal dari peradaban Babilonia bernama?",
            options = listOf("Hukum Hammurabi", "Hukum Justinianus", "Magna Charta", "Hukum Dua Belas Tabel"),
            correctAnswerIndex = 0,
            explanation = "Prasasti Kode Hammurabi dipahat pada batu diorite hitam setinggi 2,25 meter atas perintah Raja Hammurabi dari Babilonia sekitar 1750 SM.",
            category = QuizCategory.DUNIA,
            difficulty = Difficulty.MEDIUM,
            era = "1750 Sebelum Masehi",
            hint = "Dinamai sesuai nama raja Babilonia yang membuatnya."
        ),
        Question(
            id = 24,
            questionText = "Tembok Besar Tiongkok dibangun dan diperluas secara besar-besaran oleh dinasti-dinasti kekaisaran Tiongkok terutama untuk tujuan apa?",
            options = listOf(
                "Melindungi wilayah dari serangan bangsa pengembara nomaden dari utara",
                "Sebagai batas administrasi bea cukai pelabuhan",
                "Tempat penyimpanan perbendaharaan emas kaisar",
                "Jalur irigasi air nasional antar provinsi"
            ),
            correctAnswerIndex = 0,
            explanation = "Tembok Besar dibangun sejak masa Dinasti Qin dan diperkuat pada Dinasti Ming untuk membentengi perbatasan dari invasi suku-suku nomaden seperti Xiongnu dan Mongol.",
            category = QuizCategory.DUNIA,
            difficulty = Difficulty.EASY,
            era = "Dinasti Qin & Ming",
            hint = "Fungsi utama pertahanan militer perbatasan utara."
        ),
        Question(
            id = 25,
            questionText = "Kaisar Romawi pertama yang mengubah Republik Roma menjadi Kekaisaran Romawi dan memulai era Pax Romana adalah?",
            options = listOf("Kaisar Augustus (Oktavianus)", "Julius Caesar", "Nero", "Marcus Aurelius"),
            correctAnswerIndex = 0,
            explanation = "Gaius Julius Caesar Octavianus bergelar Kaisar Augustus memimpin sejak 27 SM dan mengawali masa kedamaian dan kestabilan Romawi selama dua abad.",
            category = QuizCategory.DUNIA,
            difficulty = Difficulty.MEDIUM,
            era = "27 SM - 14 M",
            hint = "Anak angkat dari Julius Caesar, namanya diabadikan dalam nama bulan Agustus."
        ),
        Question(
            id = 26,
            questionText = "Sistem tulisan paku (Cuneiform) yang dianggap sebagai sistem tulisan tertua di dunia diciptakan oleh bangsa kuno di Mesopotamia yaitu?",
            options = listOf("Bangsa Sumeria", "Bangsa Asiria", "Bangsa Het", "Bangsa Fenisia"),
            correctAnswerIndex = 0,
            explanation = "Bangsa Sumeria di Mesopotamia selatan menciptakan aksara paku pada lempengan tanah liat sekitar tahun 3200 Sebelum Masehi.",
            category = QuizCategory.DUNIA,
            difficulty = Difficulty.HARD,
            era = "3200 Sebelum Masehi",
            hint = "Bangsa tertua di lembah Sungai Tigris dan Eufrat."
        ),

        // ==========================================
        // 4. PERANG & DIPLOMASI MODERN
        // ==========================================
        Question(
            id = 27,
            questionText = "Peristiwa pemicu utama meletusnya Perang Dunia I pada Juni 1914 di Sarajevo adalah?",
            options = listOf(
                "Pembunuhan Putra Mahkota Franz Ferdinand dari Austria-Hungaria",
                "Invasi Jerman ke Polandia",
                "Serangan ke Pearl Harbor",
                "Krisis misil Kuba"
            ),
            correctAnswerIndex = 0,
            explanation = "Pembunuhan Archduke Franz Ferdinand dan istrinya oleh Gavrilo Princip di Sarajevo memicu krisis Juli yang berujung pada pecahnya Perang Dunia I.",
            category = QuizCategory.PERANG_DIPLOMASI,
            difficulty = Difficulty.MEDIUM,
            era = "Juni 1914",
            hint = "Putra mahkota kekaisaran Austria-Hungaria."
        ),
        Question(
            id = 28,
            questionText = "Perang Dunia II di kawasan Asia Pasifik berakhir setelah Amerika Serikat menjatuhkan bom atom di dua kota Jepang yaitu?",
            options = listOf(
                "Hiroshima dan Nagasaki",
                "Tokyo dan Kyoto",
                "Osaka dan Yokohama",
                "Nagoya dan Sapporo"
            ),
            correctAnswerIndex = 0,
            explanation = "Bom atom dijatuhkan di Hiroshima pada 6 Agustus 1945 dan di Nagasaki pada 9 Agustus 1945, memaksa Kaisar Hirohito mengumumkan penyerahan tanpa syarat Jepang.",
            category = QuizCategory.PERANG_DIPLOMASI,
            difficulty = Difficulty.EASY,
            era = "Agustus 1945",
            hint = "Kota pertama dijatuhi bom bernama Little Boy dan kota kedua Fat Man."
        ),
        Question(
            id = 29,
            questionText = "Konferensi Asia-Afrika (KAA) yang bersejarah diselenggarakan pada tahun 1955 di kota mana di Indonesia?",
            options = listOf("Bandung", "Jakarta", "Yogyakarta", "Surabaya"),
            correctAnswerIndex = 0,
            explanation = "KAA diadakan di Gedung Merdeka Bandung pada 18-24 April 1955, dihadiri oleh 29 negara yang melahirkan Dasasila Bandung dan pelopor Gerakan Non-Blok.",
            category = QuizCategory.PERANG_DIPLOMASI,
            difficulty = Difficulty.EASY,
            era = "April 1955",
            hint = "Ibu kota provinsi Jawa Barat yang berjuluk Kota Kembang."
        ),
        Question(
            id = 30,
            questionText = "Organisasi internasional Perserikatan Bangsa-Bangsa (PBB) didirikan pada tahun 1945 untuk menggantikan organisasi sebelumnya yang bernama?",
            options = listOf(
                "Liga Bangsa-Bangsa (LBB)",
                "Pakta Warsawa",
                "NATO",
                "Komintern"
            ),
            correctAnswerIndex = 0,
            explanation = "Liga Bangsa-Bangsa (League of Nations) didirikan pasca-PD I namun gagal mencegah meletusnya PD II, sehingga dibubarkan dan digantikan oleh PBB pada 24 Oktober 1945.",
            category = QuizCategory.PERANG_DIPLOMASI,
            difficulty = Difficulty.MEDIUM,
            era = "Tahun 1945",
            hint = "Didirikan setelah Perang Dunia I atas inisiatif Presiden Woodrow Wilson."
        ),
        Question(
            id = 31,
            questionText = "Tembok Berlin yang memisahkan Jerman Barat dan Jerman Timur selama Perang Dingin akhirnya diruntuhkan pada tahun?",
            options = listOf("1989", "1975", "1991", "1980"),
            correctAnswerIndex = 0,
            explanation = "Tembok Berlin mulai dihancurkan pada 9 November 1989 seiring runtuhnya tirai besi di Eropa Timur, disusul reunifikasi Jerman pada Oktober 1990.",
            category = QuizCategory.PERANG_DIPLOMASI,
            difficulty = Difficulty.MEDIUM,
            era = "November 1989",
            hint = "Tepat dua tahun sebelum bubarnya Uni Soviet pada 1991."
        ),
        Question(
            id = 32,
            questionText = "Gerakan Non-Blok (GNB) dibentuk pada KTT Beograd tahun 1961 yang diprakarsai oleh pemimpin dari Indonesia, Yugoslavia, Mesir, India, dan Ghana. Siapakah wakil dari Indonesia?",
            options = listOf("Ir. Soekarno", "Mohammad Hatta", "Sutan Sjahrir", "Ali Sastroamidjojo"),
            correctAnswerIndex = 0,
            explanation = "Presiden Soekarno merupakan salah satu dari lima tokoh pendiri utama GNB bersama Josip Broz Tito, Gamal Abdel Nasser, Jawaharlal Nehru, dan Kwame Nkrumah.",
            category = QuizCategory.PERANG_DIPLOMASI,
            difficulty = Difficulty.EASY,
            era = "Tahun 1961",
            hint = "Presiden pertama Republik Indonesia."
        ),
        Question(
            id = 33,
            questionText = "Pendaratan pasukan Sekutu terbesar di pesisir Normandia Prancis pada 6 Juni 1944 dalam Perang Dunia II dikenal dengan sebutan apa?",
            options = listOf("D-Day (Operasi Overlord)", "Operasi Barbarossa", "Operasi Market Garden", "Pertempuran Midway"),
            correctAnswerIndex = 0,
            explanation = "D-Day atau Operasi Overlord dipimpin oleh Jenderal Dwight D. Eisenhower untuk membebaskan Eropa Barat dari pendudukan Nazi Jerman.",
            category = QuizCategory.PERANG_DIPLOMASI,
            difficulty = Difficulty.MEDIUM,
            era = "Juni 1944",
            hint = "Singkatan dari Decision Day di pantai Normandia."
        ),

        // ==========================================
        // 5. TOKOH & REVOLUSI DUNIA
        // ==========================================
        Question(
            id = 34,
            questionText = "Revolusi Prancis tahun 1789 ditandai secara simbolis dengan penyerbuan rakyat Paris terhadap penjara apa?",
            options = listOf("Penjara Bastille", "Menara London", "Penjara Conciergerie", "Kastil Versailles"),
            correctAnswerIndex = 0,
            explanation = "Penyerbuan Penjara Bastille pada 14 Juli 1789 melambangkan perlawanan rakyat terhadap tirani monarki absolut Raja Louis XVI.",
            category = QuizCategory.TOKOH_DUNIA,
            difficulty = Difficulty.EASY,
            era = "Juli 1789",
            hint = "Hari penyerbuannya kini menjadi Hari Nasional Prancis (Bastille Day)."
        ),
        Question(
            id = 35,
            questionText = "Tokoh pemimpin perjuangan anti-apartheid yang dipenjara selama 27 tahun sebelum akhirnya menjadi presiden berkulit hitam pertama Afrika Selatan adalah?",
            options = listOf("Nelson Mandela", "Desmond Tutu", "Kofi Annan", "Patrice Lumumba"),
            correctAnswerIndex = 0,
            explanation = "Nelson Mandela memimpin gerakan rekonsiliasi nasional Afrika Selatan dan dianugerahi Nobel Perdamaian pada tahun 1993.",
            category = QuizCategory.TOKOH_DUNIA,
            difficulty = Difficulty.EASY,
            era = "Abad ke-20",
            hint = "Pernah dipenjara lama di Pulau Robben dan dikenal dengan nama klan Madiba."
        ),
        Question(
            id = 36,
            questionText = "Siapakah jenderal militer Prancis yang menobatkan dirinya sebagai Kaisar dan menaklukkan sebagian besar daratan Eropa pada awal abad ke-19?",
            options = listOf("Napoleon Bonaparte", "Louis XIV", "Charles de Gaulle", "Maximilian Robespierre"),
            correctAnswerIndex = 0,
            explanation = "Napoleon Bonaparte mereformasi hukum sipil (Code Napoléon) dan memimpin ekspedisi militer besar-besaran sebelum kalah di Pertempuran Waterloo 1815.",
            category = QuizCategory.TOKOH_DUNIA,
            difficulty = Difficulty.EASY,
            era = "1799 - 1815",
            hint = "Lahir di pulau Korsika dan diasingkan di pulau Saint Helena."
        ),
        Question(
            id = 37,
            questionText = "Deklarasi Kemerdekaan Amerika Serikat dari Kerajaan Britania Raya diikrarkan pada 4 Juli 1776, ditulis utamanya oleh tokoh siapa?",
            options = listOf("Thomas Jefferson", "George Washington", "Benjamin Franklin", "John Adams"),
            correctAnswerIndex = 0,
            explanation = "Thomas Jefferson merumuskan Declaration of Independence yang menegaskan hak asasi atas kehidupan, kebebasan, dan pencarian kebahagiaan.",
            category = QuizCategory.TOKOH_DUNIA,
            difficulty = Difficulty.MEDIUM,
            era = "Juli 1776",
            hint = "Kelak menjabat sebagai Presiden ke-3 Amerika Serikat."
        ),
        Question(
            id = 38,
            questionText = "Pemimpin gerakan kemerdekaan India yang menginspirasi dunia dengan prinsip perjuangan tanpa kekerasan (Ahimsa dan Satyagraha) adalah?",
            options = listOf("Mahatma Gandhi", "Jawaharlal Nehru", "Subhas Chandra Bose", "Rabindranath Tagore"),
            correctAnswerIndex = 0,
            explanation = "Mohandas Karamchand Gandhi (Mahatma Gandhi) memimpin aksi damai seperti Pawai Garam 1930 melawan penjajahan kolonial Inggris.",
            category = QuizCategory.TOKOH_DUNIA,
            difficulty = Difficulty.EASY,
            era = "Awal abad ke-20",
            hint = "Diberi gelar kehormatan 'Mahatma' yang bermakna Jiwa Agung."
        ),
        Question(
            id = 39,
            questionText = "Siapakah pemikir dan filsuf Yunani Kuno yang dikenal sebagai bapak filsafat Barat dan guru dari Plato?",
            options = listOf("Socrates", "Aristoteles", "Pythagoras", "Herodotus"),
            correctAnswerIndex = 0,
            explanation = "Socrates mengembangkan metode dialektika kritis (Socratic method) sebelum dijatuhi hukuman mati meminum racun cemara pada 399 SM.",
            category = QuizCategory.TOKOH_DUNIA,
            difficulty = Difficulty.MEDIUM,
            era = "Abad ke-5 Sebelum Masehi",
            hint = "Terkenal dengan kutipan 'Aku tahu bahwa aku tidak tahu apa-apa'."
        ),

        // ==========================================
        // 6. PENEMUAN & SAINS SEJARAH
        // ==========================================
        Question(
            id = 40,
            questionText = "Revolusi Industri tahap pertama pada abad ke-18 bermula di Inggris berkat penyempurnaan teknologi apa?",
            options = listOf(
                "Mesin uap oleh James Watt",
                "Listrik oleh Thomas Edison",
                "Mobil oleh Karl Benz",
                "Komputer oleh Charles Babbage"
            ),
            correctAnswerIndex = 0,
            explanation = "Penyempurnaan mesin uap oleh James Watt pada dekade 1770-an memicu mekanisasi pabrik tekstil, transportasi kereta api, dan revolusi manufaktur global.",
            category = QuizCategory.SAINS_PENEMUAN,
            difficulty = Difficulty.MEDIUM,
            era = "Abad ke-18",
            hint = "Menggunakan tenaga uap air panas untuk menggerakkan mesin."
        ),
        Question(
            id = 41,
            questionText = "Siapakah penemu teknologi cetak huruf bergerak di Eropa sekitar tahun 1440 yang memicu revolusi literasi massal?",
            options = listOf("Johannes Gutenberg", "Isaac Newton", "Galileo Galilei", "Nicolaus Copernicus"),
            correctAnswerIndex = 0,
            explanation = "Johannes Gutenberg dari Mainz Jerman menemukan mesin cetak huruf timbal, memungkinkan produksi Alkitab dan buku sains secara massal.",
            category = QuizCategory.SAINS_PENEMUAN,
            difficulty = Difficulty.MEDIUM,
            era = "Tahun 1440 Masehi",
            hint = "Alkitab cetak pertamanya dinamai Gutenberg Bible."
        ),
        Question(
            id = 42,
            questionText = "Astronom Polandia yang mengemukakan teori Heliosentris bahwa bumi dan planet-planet mengitari matahari adalah?",
            options = listOf("Nicolaus Copernicus", "Galileo Galilei", "Johannes Kepler", "Tycho Brahe"),
            correctAnswerIndex = 0,
            explanation = "Nicolaus Copernicus menerbitkan karyanya De revolutionibus orbium coelestium pada 1543 yang membantah teori geosentris Ptolemeus.",
            category = QuizCategory.SAINS_PENEMUAN,
            difficulty = Difficulty.MEDIUM,
            era = "Tahun 1543 Masehi",
            hint = "Menggulingkan anggapan lama bahwa Bumi adalah pusat semesta."
        ),
        Question(
            id = 43,
            questionText = "Penjelajah asal Portugis yang pertama kali berhasil berlayar mengelilingi Tanjung Harapan Afrika dan tiba di Calicut India pada 1498 adalah?",
            options = listOf("Vasco da Gama", "Bartolomeu Dias", "Ferdinand Magellan", "Afonso de Albuquerque"),
            correctAnswerIndex = 0,
            explanation = "Vasco da Gama membuka jalur pelayaran laut langsung dari Eropa ke Asia melintasi Samudra Hindia.",
            category = QuizCategory.SAINS_PENEMUAN,
            difficulty = Difficulty.MEDIUM,
            era = "Tahun 1498",
            hint = "Membuka rute dagang rempah-rempah langsung bangsa Portugis ke India."
        ),
        Question(
            id = 44,
            questionText = "Ilmuwan Inggris yang menemukan Penisilin sebagai antibiotik pertama di dunia pada tahun 1928 adalah?",
            options = listOf("Alexander Fleming", "Louis Pasteur", "Edward Jenner", "Robert Koch"),
            correctAnswerIndex = 0,
            explanation = "Alexander Fleming menemukan jamur Penicillium notatum yang mampu membunuh bakteri, menyelamatkan jutaan nyawa di abad ke-20.",
            category = QuizCategory.SAINS_PENEMUAN,
            difficulty = Difficulty.EASY,
            era = "Tahun 1928",
            hint = "Menemukan jamur pembunuh bakteri dari cawan petri laboratorium."
        ),
        Question(
            id = 45,
            questionText = "Ekspedisi pertama yang berhasil mengelilingi bola bumi secara penuh dipimpin oleh armada siapa pada 1519-1522?",
            options = listOf("Ferdinand Magellan & Juan Sebastián Elcano", "Christopher Columbus", "James Cook", "Marco Polo"),
            correctAnswerIndex = 0,
            explanation = "Magellan memimpin ekspedisi Spanyol, dan setelah ia tewas di Filipina, kapten Elcano menyelesaikan perjalanan kembali ke Spanyol membuktikan bumi bulat.",
            category = QuizCategory.SAINS_PENEMUAN,
            difficulty = Difficulty.MEDIUM,
            era = "Tahun 1519 - 1522",
            hint = "Selat di ujung selatan benua Amerika dinamai menurut namanya."
        ),

        // ==========================================
        // 7. PERADABAN ISLAM & JALUR SUTRA
        // ==========================================
        Question(
            id = 46,
            questionText = "Pusat penerjemahan dan akademi ilmu pengetahuan legendaris yang didirikan pada masa Kekhalifahan Abbasiyah di Baghdad bernama?",
            options = listOf("Baitul Hikmah (House of Wisdom)", "Al-Azhar", "Nizamiyya", "Madrasah Cordoba"),
            correctAnswerIndex = 0,
            explanation = "Baitul Hikmah berkembang pesat di masa Khalifah Harun Ar-Rasyid dan Al-Ma'mun sebagai pusat penerjemahan karya ilmiah Yunani, Persia, dan India.",
            category = QuizCategory.SEJARAH_ISLAM,
            difficulty = Difficulty.MEDIUM,
            era = "Abad ke-8 s.d 9 Masehi",
            hint = "Memiliki arti harfiah 'Rumah Kebijaksanaan' di Baghdad."
        ),
        Question(
            id = 47,
            questionText = "Ilmuwan muslim pencetus cabang matematika Aljabar dan algoritma angka nol yang berasal dari Khwarazm adalah?",
            options = listOf("Al-Khawarizmi", "Ibnu Sina", "Al-Biruni", "Al-Kindi"),
            correctAnswerIndex = 0,
            explanation = "Muhammad bin Musa Al-Khawarizmi menulis kitab Al-Kitab al-mukhtasar fi hisab al-jabr wa'l-muqabala yang menjadi fondasi Aljabar modern.",
            category = QuizCategory.SEJARAH_ISLAM,
            difficulty = Difficulty.EASY,
            era = "Abad ke-9 Masehi",
            hint = "Namanya diserap ke dalam kosakata matematika modern sebagai 'Algoritma'."
        ),
        Question(
            id = 48,
            questionText = "Tokoh kedokteran muslim terkemuka yang menulis ensiklopedia medis legendaris 'The Canon of Medicine' (Al-Qanun fi al-Tibb) adalah?",
            options = listOf("Ibnu Sina (Avicenna)", "Ibnu Rusyd (Averroes)", "Al-Razi (Rhazes)", "Ibnu Nafis"),
            correctAnswerIndex = 0,
            explanation = "Ibnu Sina dijuluki 'Bapak Kedokteran Modern'. Kitab Al-Qanun fi al-Tibb karyanya menjadi buku teks rujukan utama universitas-universitas Eropa selama berabad-abad.",
            category = QuizCategory.SEJARAH_ISLAM,
            difficulty = Difficulty.EASY,
            era = "Abad ke-10 s.d 11 Masehi",
            hint = "Dikenal di dunia Barat dengan sebutan Avicenna."
        ),
        Question(
            id = 49,
            questionText = "Sultan dari Kesultanan Utsmaniyah (Ottoman) yang berhasil menaklukkan kota Konstantinopel pada tahun 1453 di usia 21 tahun adalah?",
            options = listOf("Sultan Mehmed II (Al-Fatih)", "Sultan Suleiman Al-Qanuni", "Sultan Selim I", "Sultan Bayezid I"),
            correctAnswerIndex = 0,
            explanation = "Sultan Mehmed II bergelar Al-Fatih (Sang Penakluk) menaklukkan benteng Bizantium Konstantinopel pada 29 Mei 1453, mengubahnya menjadi Istanbul.",
            category = QuizCategory.SEJARAH_ISLAM,
            difficulty = Difficulty.EASY,
            era = "Mei 1453 Masehi",
            hint = "Dijuluki Al-Fatih yang bermakna Sang Penakluk."
        ),
        Question(
            id = 50,
            questionText = "Kota di wilayah semenanjung Andalusia (Spanyol) yang menjadi pusat kemajuan peradaban, sains, dan arsitektur Islam di Eropa pada Abad Pertengahan adalah?",
            options = listOf("Kordoba (Córdoba)", "Madrid", "Barcelona", "Toledo"),
            correctAnswerIndex = 0,
            explanation = "Kordoba di bawah pemerintahan Dinasti Umayyah di Spanyol memiliki perpustakaan raksasa, universitas, jalanan berlampu, dan Masjid Agung Cordoba yang memukau dunia.",
            category = QuizCategory.SEJARAH_ISLAM,
            difficulty = Difficulty.MEDIUM,
            era = "Abad ke-8 s.d 11 Masehi",
            hint = "Ibu kota Kekhalifahan Keamiran Umayyah di Andalusia."
        ),
        Question(
            id = 51,
            questionText = "Jalur perdagangan legendaris yang menghubungkan wilayah Tiongkok, Asia Tengah, Timur Tengah, hingga ke Eropa selama berabad-abad dikenal sebagai?",
            options = listOf("Jalur Sutra (Silk Road)", "Jalur Dupa", "Jalur Rempah Maritim", "Jalur Emas Sahara"),
            correctAnswerIndex = 0,
            explanation = "Jalur Sutra menjadi rute pertukaran komoditas sutra, porselen, rempah-rempah, serta pertukaran sains, budaya, dan agama antara Timur dan Barat.",
            category = QuizCategory.SEJARAH_ISLAM,
            difficulty = Difficulty.EASY,
            era = "Abad ke-2 SM s.d 15 Masehi",
            hint = "Dinamai menurut kain halus khas Tiongkok yang sangat berharga."
        )
    )

    val triviaFacts: List<TriviaItem> = listOf(
        TriviaItem(
            id = 1,
            title = "Bendera Merah Putih dari Kain Tenda?",
            detail = "Kain katun merah dan putih yang dijahit Ibu Fatmawati untuk Proklamasi berasal dari seorang perwira Jepang bernama Shimizu yang bersimpati kepada perjuangan Indonesia."
        ),
        TriviaItem(
            id = 2,
            title = "Kekuatan Angkatan Laut Majapahit",
            detail = "Majapahit memiliki armada kapal perang raksasa bernama Jung Jawa yang dapat mengangkut ratusan prajurit dan dipersenjatai meriam Cetbang karya Mpu Gandring kuno."
        ),
        TriviaItem(
            id = 3,
            title = "Keajaiban Arsitektur Candi Borobudur",
            detail = "Candi Borobudur disusun dari sekitar 2 juta balok batu vulkanik andesit yang saling mengunci dengan sistem pasak tanpa menggunakan semen atau perekat modern."
        ),
        TriviaItem(
            id = 4,
            title = "Perpustakaan Alexandria yang Hilang",
            detail = "Perpustakaan Agung Alexandria di Mesir kuno pernah menyimpan lebih dari 400.000 gulungan papirus pengetahuan sains, astronomi, dan filsafat peradaban dunia."
        ),
        TriviaItem(
            id = 5,
            title = "Dasasila Bandung Mengubah Peta Dunia",
            detail = "Konferensi Asia Afrika 1955 di Bandung mengilhami perjuangan kemerdekaan lebih dari 30 negara jajahan di benua Afrika dan Asia dalam kurun satu dekade berikutnya."
        ),
        TriviaItem(
            id = 6,
            title = "Asal Mula Kata 'Algoritma'",
            detail = "Istilah 'Algoritma' dalam ilmu komputer modern berasal dari pelafalan bangsa Barat terhadap nama matematikawan muslim Persia abad ke-9, Al-Khawarizmi."
        ),
        TriviaItem(
            id = 7,
            title = "Penerangan Jalan Kordoba Abad ke-10",
            detail = "Pada abad ke-10 saat sebagian besar kota Eropa masih gelap gulita di malam hari, Kordoba di Andalusia telah memiliki lebih dari 70 perpustakaan dan jalanan beraspal dengan lentera lampu umum."
        ),
        TriviaItem(
            id = 8,
            title = "Pena Bulu dan Tinta Declaration of Independence",
            detail = "Naskah asli Deklarasi Kemerdekaan Amerika Serikat ditulis di atas lembaran perkamen kulit hewan yang diawetkan khusus agar mampu bertahan ratusan tahun."
        )
    )
}

data class TriviaItem(
    val id: Int,
    val title: String,
    val detail: String
)
