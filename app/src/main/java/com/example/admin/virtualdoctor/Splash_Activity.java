package com.example.admin.virtualdoctor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;



public class Splash_Activity extends AppCompatActivity {

    protected boolean active=true;
    protected int splashTime=2000;
    private LoginPreferences loginPreferences;
    private android.support.v7.app.ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_);
        loginPreferences = new LoginPreferences(this);
        actionBar = getSupportActionBar();
        actionBar.hide();


        Thread splashThread=new Thread()
        {
            public void run()
            {
                try
                {
                    int waited=0;

                    while(active && (waited<splashTime))
                    {
                        sleep(100);
                        if(active)
                        {
                            waited +=100;
                        }
                    }
                }
                catch(Exception e)
                {
                    e.toString();
                }

                finally
                {
                    if (loginPreferences.getStatus())
                    {
                        startActivity(new Intent(Splash_Activity.this,MainActivity.class));
                        //Toast.makeText(Splash_Activity.this, "Please Login", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        startActivity(new Intent(Splash_Activity.this,Login.class));
                        //Toast.makeText(Splash_Activity.this, "Login in First", Toast.LENGTH_SHORT).show();
                    }



                }
            }
        };

        splashThread.start();

    }
}
