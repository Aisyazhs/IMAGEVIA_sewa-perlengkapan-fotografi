package com.akhir.imagevia2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DaftarAlatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_alat);
    }

    public void hal_sewa(View view) {
        Intent intent =new Intent(DaftarAlatActivity.this, SewaAlatActivity.class);
        startActivity(intent);
    }
}

