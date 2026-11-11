package com.rahmad.gajikaryawan;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.math.BigDecimal;

/** Halaman Info Gaji Karyawan (fitur utama): input, validasi, hitung, reset. */
public class GajiActivityRahmad extends AppCompatActivity {

    private TextInputLayout tilNik, tilNama, tilGajiPokok, tilTunjanganJabatan, tilHariKerja;
    private TextInputEditText etNik, etNama, etGajiPokok, etTunjanganJabatan, etHariKerja;
    private View cardHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gaji_rahmad);

        tilNik = findViewById(R.id.tilNik);
        tilNama = findViewById(R.id.tilNama);
        tilGajiPokok = findViewById(R.id.tilGajiPokok);
        tilTunjanganJabatan = findViewById(R.id.tilTunjanganJabatan);
        tilHariKerja = findViewById(R.id.tilHariKerja);

        etNik = findViewById(R.id.etNik);
        etNama = findViewById(R.id.etNama);
        etGajiPokok = findViewById(R.id.etGajiPokok);
        etTunjanganJabatan = findViewById(R.id.etTunjanganJabatan);
        etHariKerja = findViewById(R.id.etHariKerja);
        cardHasil = findViewById(R.id.cardHasil);

        findViewById(R.id.btnHitung).setOnClickListener(v -> hitung());
        findViewById(R.id.btnReset).setOnClickListener(v -> reset());
        findViewById(R.id.btnKembaliGaji).setOnClickListener(v -> finish());
    }

    private void hitung() {
        // Hapus pesan error lama
        tilNik.setError(null);
        tilNama.setError(null);
        tilGajiPokok.setError(null);
        tilTunjanganJabatan.setError(null);
        tilHariKerja.setError(null);

        String nik = teks(etNik);
        String nama = teks(etNama);
        String gajiPokokStr = teks(etGajiPokok);
        String tunjanganStr = teks(etTunjanganJabatan);
        String hariStr = teks(etHariKerja);

        // ---- VALIDASI ----
        boolean valid = true;

        if (nik.isEmpty()) {
            tilNik.setError("NIK wajib diisi");
            valid = false;
        }
        if (nama.isEmpty()) {
            tilNama.setError("Nama karyawan wajib diisi");
            valid = false;
        }
        if (gajiPokokStr.isEmpty()) {
            tilGajiPokok.setError("Gaji pokok wajib diisi");
            valid = false;
        } else if (!gajiPokokStr.matches("\\d{1,12}")) {
            tilGajiPokok.setError("Masukkan angka yang valid (tanpa titik/koma)");
            valid = false;
        }
        if (tunjanganStr.isEmpty()) {
            tilTunjanganJabatan.setError("Tunjangan jabatan wajib diisi");
            valid = false;
        } else if (!tunjanganStr.matches("\\d{1,12}")) {
            tilTunjanganJabatan.setError("Masukkan angka yang valid (tanpa titik/koma)");
            valid = false;
        }
        if (hariStr.isEmpty()) {
            tilHariKerja.setError("Jumlah hari kerja wajib diisi");
            valid = false;
        } else if (!hariStr.matches("\\d{1,3}") || Long.parseLong(hariStr) < 1) {
            tilHariKerja.setError("Harus bilangan bulat positif (minimal 1)");
            valid = false;
        } else if (Long.parseLong(hariStr) > 31) {
            tilHariKerja.setError("Hari kerja maksimal 31 hari");
            valid = false;
        }

        if (!valid) {
            cardHasil.setVisibility(View.GONE);
            return;
        }

        // ---- PERHITUNGAN (logika ada di GajiCalculatorRahmad) ----
        GajiCalculatorRahmad hasil = new GajiCalculatorRahmad(
                new BigDecimal(gajiPokokStr),
                new BigDecimal(tunjanganStr),
                Long.parseLong(hariStr));

        // ---- TAMPILKAN HASIL ----
        ((android.widget.TextView) findViewById(R.id.tvHasilNik)).setText("NIK: " + nik);
        ((android.widget.TextView) findViewById(R.id.tvHasilNama)).setText("Nama: " + nama);
        ((android.widget.TextView) findViewById(R.id.tvTunjanganMakan))
                .setText(GajiCalculatorRahmad.formatRupiah(hasil.tunjanganMakan));
        ((android.widget.TextView) findViewById(R.id.tvTunjanganTransport))
                .setText(GajiCalculatorRahmad.formatRupiah(hasil.tunjanganTransport));
        ((android.widget.TextView) findViewById(R.id.tvGajiKotor))
                .setText(GajiCalculatorRahmad.formatRupiah(hasil.gajiKotor));
        ((android.widget.TextView) findViewById(R.id.tvPajak))
                .setText(GajiCalculatorRahmad.formatRupiah(hasil.pajak));
        ((android.widget.TextView) findViewById(R.id.tvGajiBersih))
                .setText(GajiCalculatorRahmad.formatRupiah(hasil.gajiBersih));
        cardHasil.setVisibility(View.VISIBLE);
    }

    /** Hapus semua input + hasil. */
    private void reset() {
        etNik.setText("");
        etNama.setText("");
        etGajiPokok.setText("");
        etTunjanganJabatan.setText("");
        etHariKerja.setText("");
        tilNik.setError(null);
        tilNama.setError(null);
        tilGajiPokok.setError(null);
        tilTunjanganJabatan.setError(null);
        tilHariKerja.setError(null);
        cardHasil.setVisibility(View.GONE);
        etNik.requestFocus();
    }

    private String teks(TextInputEditText et) {
        return et.getText() == null ? "" : et.getText().toString().trim();
    }
}
