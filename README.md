# Aplikasi Gaji Karyawan

Proyek aplikasi Android untuk tugas perhitungan gaji karyawan.

## Teknologi
- Java
- XML Layout
- Android Gradle Plugin 8.5.2
- Gradle 8.7
- compileSdk 34, minSdk 24

## Fitur
- Menu utama
- Info/perhitungan gaji karyawan
- Petunjuk penggunaan
- Tentang aplikasi
- Keluar dengan konfirmasi

## Rumus
- Tunjangan makan = jumlah hari kerja x Rp10.000
- Tunjangan transportasi = jumlah hari kerja x Rp5.000
- Gaji kotor = gaji pokok + tunjangan jabatan + tunjangan makan + tunjangan transportasi
- Pajak = 10% x gaji kotor
- Gaji bersih = gaji kotor - pajak

## Membuat APK tanpa Android Studio di laptop
Repository ini dilengkapi GitHub Actions. Setelah proyek diunggah ke GitHub pada branch `main` atau `master`, workflow **Build APK Gaji Karyawan** akan berjalan otomatis.

Untuk mengambil APK:
1. Buka repository GitHub.
2. Pilih tab **Actions**.
3. Buka workflow **Build APK Gaji Karyawan** yang terbaru.
4. Tunggu sampai statusnya berhasil (hijau / Success).
5. Buka hasil run tersebut dan unduh artifact **GajiKaryawan-APK**.
6. Ekstrak artifact ZIP untuk mendapatkan `app-debug.apk`.

Jika workflow belum berjalan otomatis, buka tab **Actions**, pilih workflow tersebut, klik **Run workflow**, lalu jalankan pada branch `main`.

## Membuka proyek di Android Studio
Pilih **Open** lalu pilih folder utama `GajiKaryawan` yang berisi `settings.gradle`.
