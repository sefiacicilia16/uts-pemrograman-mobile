package com.example.galeribudaya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton btnTari,btnRumah;
    public static final String JENIS_GALERI_KEY = "JENIS_GALERI";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inisialisasiView();

    }

    private void inisialisasiView() {
        btnTari= findViewById(R.id.btn_buka_nama_tari);
        btnRumah= findViewById(R.id.btn_buka_nama_rumah);
        btnTari.setOnClickListener(view -> bukaGaleri("Tarian"));
        btnRumah.setOnClickListener(view -> bukaGaleri("RumahTradisional"));

    }

    private void bukaGaleri(String jenisBudaya) {
        Log.d("MAIN","Buka activity Tari");
        Intent intent = new Intent(this, GaleriActivity.class);
        intent.putExtra(JENIS_GALERI_KEY, jenisBudaya);
        startActivity(intent);
    }

}

