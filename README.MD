1. Fitur Utama Kalkulator
   * Operasi Matematika Dasar: Mendukung Penjumlahan (+), Pengurangan (-), Perkalian (×), dan Pembagian (÷).
   * Validasi Input: * Mencegah bug "dobel titik" (desimal ganda) dalam satu angka.
   * Membatasi panjang input maksimal 15 karakter agar tampilan UI tidak overflow.
   * Proteksi Error (Type-Safety): Penanganan khusus untuk kasus pembagian dengan nol, mengembalikan status "Error" tanpa membuat aplikasi crash.
   * Manajemen Koreksi: Dilengkapi fitur AC (Clear All) untuk mereset seluruh perhitungan dan DEL (Delete) untuk menghapus karakter/operator terakhir secara bertahap.
   * Formatting Hasil: Otomatis menghilangkan ".0" di belakang angka jika hasil perhitungan adalah bilangan bulat murni.

2. Arsitektur & Tech Stack
   * Pendekatan Modular: Menggunakan prinsip Clean Architecture dengan struktur Folder by Feature untuk memisahkan business logic dan UI secara tegas.
   * Pola Desain UI: MVVM (Model-View-ViewModel) ditambah dengan MVI-style Event Handling menggunakan Sealed Interface.
   * Tech Stack Utama: * Kotlin (Bahasa utama).
        Jetpack Compose (Toolkit UI deklaratif murni stateless).
        Kotlin Coroutines & StateFlow (Manajemen state reaktif).
        Manual Dependency Injection (via AppContainer dan ViewModelFactory).
