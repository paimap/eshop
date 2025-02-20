# Modul 1
## Exercise 1
Untuk mengikuti clean code principle,saya menerapkan meaningful names dalam kode saya dengan menggunakan penamaan variabel yang sudah sesuai dengan konteks variabel tersebut dalam kode saya. Saya juga berusaha untuk membuat nama fungsi yang mendeskripsikan kegunaan dari fungsi tersebut. Selain itu, saya juga membuat fungsi yang melakukan hal-hal spesifik. Saya tidak menggunakan comments dalam kode saya karena saya merasa kode saya sudah cukup menjelaskan dirinya sendiri. Penggunaan beberapa error handling pada kode saya bertujuan untuk mencegah error yang tidak terduga. Untuk memperbaiki kode saya, saya merasa harus memperbaiki kode saya agar tidak mereturn null sehingga tidak membingungkan.

Dalam rangka menerapkan secure coding practices saya menggunakan uuid sebagai id dari masing-masing item. Hal itu guna menghindari ID enumeration dan memperbaiki keamanan dalam sistem terdistribusi.

## Exercise 2
1. Setelah melakukan unit test, saya merasa lebih percaya pada kebenaran kode saya. Unit test membantu saya mengidentifikasi terjadinya bug pada kode saya dan memastikan kode saya bekerja sesuai harapan saya. Jumlah unit test yang diperlukan bergantung pada kompleksitas program tersebut. Unit test yang baik adalah unit test yang menguji berbagai skenario termasuk edge case. Code coverage 100% tidak berarti bahwa kode tidak ada bug. Code coverage hanya menunjukkan bahwa setiap baris kode telah dieksekusi oleh test, tetapi tidak menjamin bahwa semua kemungkinan skenario dan edge cases telah diuji. Oleh karena itu, selain memperhatikan code coverage, kita harus memastikan bahwa program kita menjalankan fungsionalitasnya dengan baik.
2. Saya merasa kode dari rangkain fungsionalitas yang baru sudah cukup menerapkan clean code principles. Hal itu karena saya menerapkan pemisahan concerns yang akan meningkatkan readability dan maintainability. Namun ada beberapa yang bisa diperbaiki dalam kode saya seperti beberapa functional test yang memiliki setup mirip atau sama dengan functional test sebelumnya.

# Modul 2
## Exercise 1
1. Group dependencies by their destination.
menyusun ulang blok depedencies dengan sub-kelompok yang lebih jelas
2. Make sure this SonarQube token gets revoked, changed, and removed from the code.
Simpan token dengan variable secret
3. Replace this use of System.out by a logger.
ganti debugin dengan logger atau hapus debuging setelah selesai proses debug
4. Remove this unused import 'java.util.Collections'.
hapus import terkait

## Exercise 2
Ye, saat ini sudah sesuai dengan definisi dari CI dan CD. Untuk CI, setiap proses commit sudah memicu proses build dan pengujian otomatis. Sedangkan untuk CD, buld yang berhasil akan langsung dideploy ke staging atau production melalui koyeb