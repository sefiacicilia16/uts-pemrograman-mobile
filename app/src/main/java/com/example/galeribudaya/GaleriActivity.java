package com.example.galeribudaya;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import com.example.galeribudaya.model.Budaya;


public class GaleriActivity extends AppCompatActivity {

    List<Budaya> budayas;
    int indeksTampil = 0;
    String jenisBudaya;
    Button btnPertama,btnTerakhir,btnSebelumnya,btnBerikutnya;
    TextView txAsal,txDeskripsi,txJudul,txNama;
    ImageView ivFotoBudaya;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_nama);
        Intent intent = getIntent();
        jenisBudaya= intent.getStringExtra(MainActivity.JENIS_GALERI_KEY);
        budayas = DataProvider.getBudayasByTipe(this, jenisBudaya);
        inisialisasiView();
        tampilkanProfil();
    }

    private void inisialisasiView() {
        btnPertama = findViewById(R.id.btnPertama);
        btnSebelumnya = findViewById(R.id.btnSebelumnya);
        btnBerikutnya = findViewById(R.id.btnBerikutnya);
        btnTerakhir = findViewById(R.id.btnTerakhir);

        btnPertama.setOnClickListener(view -> budayaPertama());
        btnTerakhir.setOnClickListener(view -> budayaTerakhir());
        btnSebelumnya.setOnClickListener(view -> budayaSebelumnya());
        btnBerikutnya.setOnClickListener(view -> budayaBerikutnya());

        txNama = findViewById(R.id.txNama);
        txAsal= findViewById(R.id.txAsal);
        txDeskripsi = findViewById(R.id.txDeskripsi);
        ivFotoBudaya = findViewById(R.id.gambarBudaya);

        txJudul = findViewById(R.id.txJudul);
        txJudul.setText("Berbagai Macam Nama "+jenisBudaya);
    }

    private void tampilkanProfil() {
        Budaya p = budayas.get(indeksTampil);
        Log.d("Rumah","Menampilkan rumah"+p.getJenis());
        txAsal.setText(p.getAsal());
        txNama.setText(p.getNama());
        txDeskripsi.setText(p.getDeskripsi());
        ivFotoBudaya.setImageDrawable(this.getDrawable(p.getDrawableRes()));
    }

    private void budayaPertama() {
        int posAwal = 0;
        if (indeksTampil == posAwal) {
            Toast.makeText(this,"Sudah di posisi pertama",Toast.LENGTH_SHORT).show();
            return;
        } else {
            indeksTampil = posAwal;
            tampilkanProfil();
        }
    }

    private void budayaTerakhir() {
        int posAkhir = budayas.size() - 1;
        if (indeksTampil == posAkhir) {
            Toast.makeText(this,"Sudah di posisi_terakhir",Toast.LENGTH_SHORT).show();
            return;
        } else {
            indeksTampil = posAkhir;
            tampilkanProfil();
        }
    }

    private void budayaBerikutnya() {
        if (indeksTampil == budayas.size() - 1) {
            Toast.makeText(this,"Sudah di posisi terakhir",Toast.LENGTH_SHORT).show();
            return;
        } else {
            indeksTampil++;
            tampilkanProfil();
        }
    }

    private void budayaSebelumnya() {
        if (indeksTampil == 0) {
            Toast.makeText(this,"Sudah di posisi pertama",Toast.LENGTH_SHORT).show();
            return;
        } else {
            indeksTampil--;
            tampilkanProfil();
        }
    }
}