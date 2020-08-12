package com.example.admin.virtualdoctor;

import android.app.FragmentManager;
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

public class BloodBank extends AppCompatActivity {

    WebView webViewBloodbank;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_bank);
        webViewBloodbank=findViewById(R.id.nearbyBloodbankWebView);

        this.setTitle("Nearby Blood Banks");
        String url= "http://maps.google.com/maps?q=blood+bank&mrt=yp&sll=lat,lon&output=kml";
        webViewBloodbank.setWebViewClient(new WebViewClient());
        WebSettings webSettings= webViewBloodbank.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webViewBloodbank.loadUrl("http://maps.google.com/maps?q=blood+bank&mrt=yp&sll=lat,lon&output=kml");
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && webViewBloodbank.canGoBack()) {
            webViewBloodbank.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
