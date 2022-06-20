package com.akhir.imagevia2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;

public class SewaAlatActivity extends AppCompatActivity {
    int harga_sewa_perlengkapan,jml_lmsw,ttl_hargasewa,jml_uang;
    String s_nama;

    Spinner ad_listperlengkapan;
    TextView harga_perlengkapan;
    EditText lama_sewa,uangbayar,nama_penyewa;


    String list_perlengkapan[] = {"camera canon","camera sony","paket studio lighting","Lensa canon"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sewa_alat);
        nama_penyewa = findViewById(R.id.nama_penyewa);
        ad_listperlengkapan = findViewById(R.id.ad_listperlengkapan);
        harga_perlengkapan = findViewById(R.id.harga_perlengkapan);
        lama_sewa = findViewById(R.id.lama_sewa);
        uangbayar = findViewById(R.id.uangbayar);

        ArrayAdapter ad_prl = new ArrayAdapter(SewaAlatActivity.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,list_perlengkapan);
        ad_listperlengkapan.setAdapter(ad_prl);


    }

    public void tmbl_OK (View view) {
        jml_lmsw= Integer.parseInt(lama_sewa.getText().toString());
        s_nama = nama_penyewa.getText().toString();


        if(ad_listperlengkapan.getSelectedItem().toString()=="Canon 1200D"){
            harga_sewa_perlengkapan = 200000;
            ttl_hargasewa = jml_lmsw * harga_sewa_perlengkapan;
            harga_perlengkapan.setText(Integer.toString(ttl_hargasewa));
        } else if (ad_listperlengkapan.getSelectedItem().toString() == "HXR-MC2500"){
            harga_sewa_perlengkapan = 250000;
            ttl_hargasewa = jml_lmsw * harga_sewa_perlengkapan;
            harga_perlengkapan.setText(Integer.toString(ttl_hargasewa));
        } else if (ad_listperlengkapan.getSelectedItem().toString() == "Paket Studio Lighting"){
            harga_sewa_perlengkapan = 300000;
            ttl_hargasewa = jml_lmsw * harga_sewa_perlengkapan;
            harga_perlengkapan.setText(Integer.toString(ttl_hargasewa));
        } else if (ad_listperlengkapan.getSelectedItem().toString() == "EF 35mm F/2 IS USM"){
            harga_sewa_perlengkapan = 100000;
            ttl_hargasewa = jml_lmsw * harga_sewa_perlengkapan;
            harga_perlengkapan.setText(Integer.toString(ttl_hargasewa));
        }

    }

    public void tombol_sewa2(View view) {
        jml_uang = Integer.parseInt(uangbayar.getText().toString());
        if (jml_uang < ttl_hargasewa) {
            Toast.makeText(this, "Uang Anda Kurang", Toast.LENGTH_SHORT).show();
        }else{
            Intent intent = new Intent(SewaAlatActivity.this,StrukActivity.class);

            intent.putExtra("nama",s_nama);
            intent.putExtra("mobil",ad_listperlengkapan.getSelectedItem().toString());
            intent.putExtra("lama",jml_lmsw);
            intent.putExtra("total",ttl_hargasewa);
            intent.putExtra("uang",jml_uang);
            intent.putExtra("kembalian",jml_uang-ttl_hargasewa);

            startActivity(intent);
        }
    }

    public void hal_utama(View view) {
        Intent intent = new Intent(SewaAlatActivity.this,MainActivity.class);
        startActivity(intent);
    }
}
