package com.example.admin.virtualdoctor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class Ambulance extends AppCompatActivity {
    WebView webViewAmbulance;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ambulance);

        webViewAmbulance=findViewById(R.id.nearbyAmbulanceWebView);

        this.setTitle("Nearby Ambulance Services");
        String url= "http://maps.google.com/maps?q=hospital&mrt=yp&sll=lat,lon&output=kml";
        webViewAmbulance.setWebViewClient(new WebViewClient());
        WebSettings webSettings= webViewAmbulance.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webViewAmbulance.loadUrl("http://maps.google.com/maps?q=ambulance&mrt=yp&sll=lat,lon&output=kml");
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();


    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && webViewAmbulance.canGoBack()) {
            webViewAmbulance.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
