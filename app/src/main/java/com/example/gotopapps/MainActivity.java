package com.example.gotopapps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    CardView cvHospital, cvStore, cvHotel, cvRepairCar;
    Button btnEmergency;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cvHospital = findViewById(R.id.cv_hospital);
        cvStore = findViewById(R.id.cv_store);
        cvHotel = findViewById(R.id.cv_hotel);
        cvRepairCar = findViewById(R.id.cv_repair_car);
        btnEmergency = findViewById(R.id.btn_emergency);

        cvHospital.setOnClickListener(this);
        cvStore.setOnClickListener(this);
        cvHotel.setOnClickListener(this);
        cvRepairCar.setOnClickListener(this);
        btnEmergency.setOnClickListener(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Objects.requireNonNull(getSupportActionBar()).setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;

        if (v.getId() == R.id.cv_hospital) {
            intent = new Intent(MainActivity.this, ListHospital.class);
        } else if (v.getId() == R.id.cv_store) {
            intent = new Intent(MainActivity.this, ListStore.class);
        } else if (v.getId() == R.id.cv_hotel) {
            intent = new Intent(MainActivity.this, ListHotel.class);
        } else if (v.getId() == R.id.cv_repair_car) {
            intent = new Intent(MainActivity.this, ListRepairCar.class);
        } else if (v.getId() == R.id.btn_emergency) {
            intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:199"));
        }

        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}