package com.rahmad.gajikaryawan;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

/** Halaman Tentang Aplikasi. Teks bisa diedit di res/values/strings.xml. */
public class TentangActivityRahmad extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tentang_rahmad);

        findViewById(R.id.btnKembaliTentang).setOnClickListener(v -> finish());
    }
}
