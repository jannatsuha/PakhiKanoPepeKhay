package com.example.admin.virtualdoctor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class HospitalDetailsActivity extends AppCompatActivity {

    Button btnNearby,btnAllHospital;
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_details);
        btnNearby=findViewById(R.id.btnNearby);
        btnAllHospital=findViewById(R.id.btnHospitalAll);
        this.setTitle("Hospital Details");
    }

    public void nearbyHospitals(View view) {

        Intent intent1 = new Intent(HospitalDetailsActivity.this, NearbyHospitalMap.class);
        startActivity(intent1);
    }

    public void allHospitalLists(View view) {
        btnNearby.setVisibility(View.GONE);
        btnAllHospital.setVisibility(View.GONE);


    }
}
