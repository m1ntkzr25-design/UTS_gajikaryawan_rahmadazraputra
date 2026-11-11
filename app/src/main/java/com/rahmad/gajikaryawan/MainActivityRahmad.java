package com.rahmad.gajikaryawan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

/** Halaman Menu Utama. */
public class MainActivityRahmad extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_rahmad);

        View cardInfoGaji = findViewById(R.id.cardInfoGaji);
        View cardPetunjuk = findViewById(R.id.cardPetunjuk);
        View cardTentang = findViewById(R.id.cardTentang);
        View cardExit = findViewById(R.id.cardExit);

        cardInfoGaji.setOnClickListener(v ->
                startActivity(new Intent(this, GajiActivityRahmad.class)));

        cardPetunjuk.setOnClickListener(v ->
                startActivity(new Intent(this, PetunjukActivityRahmad.class)));

        cardTentang.setOnClickListener(v ->
                startActivity(new Intent(this, TentangActivityRahmad.class)));

        cardExit.setOnClickListener(v -> tampilkanDialogExit());
    }

    /** Dialog konfirmasi keluar: YA = keluar, TIDAK = batal. */
    private void tampilkanDialogExit() {
        new AlertDialog.Builder(this)
                .setTitle(R.string.dialog_exit_judul)
                .setMessage(R.string.dialog_exit_pesan)
                .setCancelable(false)
                .setPositiveButton(R.string.ya, (dialog, which) -> finishAffinity())
                .setNegativeButton(R.string.tidak, (dialog, which) -> dialog.dismiss())
                .show();
    }
}
