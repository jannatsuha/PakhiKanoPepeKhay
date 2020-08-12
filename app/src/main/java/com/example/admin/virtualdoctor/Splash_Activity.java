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
        Singleton.getInstance().getFrameList().add("ComfortDiagnostic");
        Singleton.getInstance().getFrameList().add("DhakaMedical");
        Singleton.getInstance().getFrameList().add("MonowaraHospital");
        Singleton.getInstance().getFrameList().add("SamoritaHospital");
        Singleton.getInstance().getFrameList().add("farazyDiagnostic&hospital");
        Singleton.getInstance().getFrameList().add("skinsquare");
        Singleton.getInstance().getFrameList().add("UnitedHospitalLtd");
        Singleton.getInstance().getFrameList().add("bangladeshSpecializedHospital");
        Singleton.getInstance().getFrameList().add("SquareHospitalLtd");
        Singleton.getInstance().getFrameList().add("ApolloHospitalDhaka");
        Singleton.getInstance().getFrameList().add("LabAidCardiacHospital");
        Singleton.getInstance().getFrameList().add("IbnSinaDiagnostic");
        Singleton.getInstance().getFrameList().add("CityHospitalLtd");
        Singleton.getInstance().getFrameList().add("OthersHospital");
        Singleton.getInstance().getFrameList().add("LabAidCardiacHospital");
        Singleton.getInstance().getFrameList().add("al-MarkajulIslamHospital");
        Singleton.getInstance().getFrameList().add("al-helalSpecializedHospital");
        Singleton.getInstance().getFrameList().add("apolloHospitalDhaka");
        Singleton.getInstance().getFrameList().add("bananiClinic");
        Singleton.getInstance().getFrameList().add("brbHospital");
        Singleton.getInstance().getFrameList().add("centralHospital");
        Singleton.getInstance().getFrameList().add("cityHospital");
        Singleton.getInstance().getFrameList().add("comfortDiagnosticCentre");
        Singleton.getInstance().getFrameList().add("dhakaCommunityMedicalCollegeHospital");
        Singleton.getInstance().getFrameList().add("dhakaMedicalCollegeHospital");
        Singleton.getInstance().getFrameList().add("japanBangladeshFriendshipHospita");
        Singleton.getInstance().getFrameList().add("labAidDiagnosticCenter");
        Singleton.getInstance().getFrameList().add("labAidSpecializedHospital");
        Singleton.getInstance().getFrameList().add("medinovaMedical");
        Singleton.getInstance().getFrameList().add("Al-RaziIslamiaHospital");
        Singleton.getInstance().getFrameList().add("farazyDiagnostic&hospital");
        Singleton.getInstance().getFrameList().add("farazyHospitalLtd");
        Singleton.getInstance().getFrameList().add("medinovaMedicalServices");
        Singleton.getInstance().getFrameList().add("skinsquare");
        Singleton.getInstance().getFrameList().add("unitedHospital");
        Singleton.getInstance().getFrameList().add("unityAidHospitalLtd");
        Singleton.getInstance().getFrameList().add("prescriptionPointLtd");
        Singleton.getInstance().getFrameList().add("talhaHealthCare");
        Singleton.getInstance().getFrameList().add("praavaHealth");
        Singleton.getInstance().getFrameList().add("bananiClinicLtd");
        Singleton.getInstance().getFrameList().add("bangladeshEyeHospital");
        Singleton.getInstance().getFrameList().add("anwarKhanModernMedicalCollege");
        Singleton.getInstance().getFrameList().add("comfortDiagnosticCentreLtd");
        Singleton.getInstance().getFrameList().add("centralHospitalLimited");
        Singleton.getInstance().getFrameList().add("greenLifeMedical");
//        Singleton.getInstance().getFrameList().add("");
//        Singleton.getInstance().getFrameList().add("");
//        Singleton.getInstance().getFrameList().add("");
//        Singleton.getInstance().getFrameList().add("");
//        Singleton.getInstance().getFrameList().add("");
//        Singleton.getInstance().getFrameList().add("");
//        Singleton.getInstance().getFrameList().add("");
//        Singleton.getInstance().getFrameList().add("");




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
                        startActivity(new Intent(Splash_Activity.this,MenuSelection.class));
                        //Toast.makeText(Splash_Activity.this, "Please Login", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        startActivity(new Intent(Splash_Activity.this,MenuSelection.class));
                        //Toast.makeText(Splash_Activity.this, "Login in First", Toast.LENGTH_SHORT).show();
                    }



                }
            }
        };

        splashThread.start();

    }
}
