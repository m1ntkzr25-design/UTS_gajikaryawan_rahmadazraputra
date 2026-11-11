package com.rahmad.gajikaryawan;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

/** Halaman Petunjuk Penggunaan. */
public class PetunjukActivityRahmad extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_petunjuk_rahmad);

        // Tombol KEMBALI: tutup halaman ini -> otomatis kembali ke Menu Utama
        findViewById(R.id.btnKembaliPetunjuk).setOnClickListener(v -> finish());
    }
}
