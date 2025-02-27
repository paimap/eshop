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
Ya, saat ini sudah sesuai dengan definisi dari CI dan CD. Untuk CI, setiap proses commit sudah memicu proses build dan pengujian otomatis. Sedangkan untuk CD, buld yang berhasil akan langsung dideploy ke staging atau production melalui koyeb

# Modul 3
1. Saya telah menerapkan Single Responsibility Principle (SRP) dengan memastikan setiap kelas memiliki tanggung jawabnya masing-masing. Car merepresentasikan data mobil, CarController menangani permintaan HTTP, CarRepository hanya bertanggung jawab untuk akses data, dan CarService mengelola logika bisnis.
Saya juga telah menerapkan Open/Closed Principle (OCP), di mana kode saya dapat diperluas tanpa perlu mengubah kode yang sudah ada.
Untuk Liskov Substitution Principle (LSP), saya membuat Controller Interface karena sebelumnya CarControllermewarisi ProductController, yang menyebabkan pelanggaran LSP karena CarController tidak dapat menggantikan ProductController sepenuhnya.
Saya juga telah menerapkan Interface Segregation Principle (ISP) dengan memastikan bahwa CarService hanya berisi metode yang benar-benar diperlukan oleh CarServiceImplementation, tanpa metode yang tidak digunakan.
Terakhir, untuk Dependency Inversion Principle (DIP), saya telah mengubah CarController agar tidak lagi bergantung pada kelas konkret. Awalnya, CarController bergantung langsung pada CarServiceImplementation, tetapi kini bergantung pada CarService.
2. Implementasi SRP dalam kode saya mempermudah pemeliharaan. Jika terdapat perubahan dalam logika bisnis, saya hanya perlu memodifikasi CarService tanpa harus mengubah CarController atau CarRepository.

Penerapan OCP memungkinkan sistem lebih mudah diskalakan. Saya dapat menambahkan fitur baru tanpa mengubah kode yang sudah ada, sehingga mengurangi risiko kesalahan atau bug.

Dengan menerapkan LSP, fleksibilitas dan kemampuan penggunaan ulang kode meningkat. Struktur hierarki menjadi lebih jelas, sehingga lebih mudah untuk menambahkan tipe produk lain di masa depan tanpa konflik.

Penerapan ISP menjadikan kode lebih efisien. Dependensi yang tidak diperlukan dapat dihindari, kode menjadi lebih terstruktur, dan hanya metode yang relevan yang diimplementasikan dalam setiap kelas.

Sementara itu, DIP meningkatkan keterujian dan fleksibilitas sistem. Saya dapat menggunakan mock implementation untuk pengujian unit dan mengganti CarServiceImpl dengan implementasi lain tanpa mempengaruhi CarController.
3. Tanpa SRP, kode menjadi sulit dipelihara dan diperbaiki. Misalnya, jika CarController menangani permintaan HTTP, logika bisnis, dan akses database sekaligus, setiap perubahan dalam logika bisnis akan mengharuskan saya untuk mengedit CarController.

Tanpa OCP, kode sulit untuk dikembangkan dan lebih rentan terhadap bug. Sebagai contoh, jika saya ingin menambahkan jenis kendaraan baru seperti Bike, tanpa menerapkan OCP, saya harus langsung mengubah CarServiceImpl, yang dapat menyebabkan ketidakstabilan dalam sistem.

Tanpa LSP, struktur hierarki kelas menjadi tidak konsisten dan kurang dapat digunakan kembali. Contohnya, jika CarController mewarisi ProductController tetapi tidak bisa sepenuhnya menggantikan fungsinya, maka kode dapat menghasilkan error saat runtime atau memerlukan banyak kondisi if-else tambahan untuk menangani kasus tertentu.

Tanpa ISP, kode menjadi lebih berat dan tidak efisien. Jika CarService memiliki metode yang tidak relevan, maka CarServiceImpl tetap harus mengimplementasikan metode tersebut meskipun tidak digunakan, yang membuat kode lebih kompleks dan sulit dikelola.

Tanpa DIP, kode menjadi sulit diuji dan kurang fleksibel. Jika CarController memiliki ketergantungan langsung pada CarServiceImpl, maka pengujian unit akan menjadi lebih sulit dilakukan karena tidak memungkinkan penggunaan mock implementation untuk simulasi dependensi.
