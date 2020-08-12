package com.example.admin.virtualdoctor;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MenuSelection extends BaseActivity {


    ArrayList<String> list;
    String phoneNumber;
    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;
    private LoginPreferences loginPreferences;
    DoctorModel doctorModel, doctorModel2, doctorModel3;
    private android.support.v7.app.ActionBar actionBar;
    BaseActivity baseActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_selection);
        actionBar = getSupportActionBar();
       // actionBar.hide();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();

        loginPreferences = new LoginPreferences(this);

//        fdb = DataBaseUtil.getDatabase();

    }


    public void chatbot(View view) {


        if (loginPreferences.getStatus())
        {
            startActivity(new Intent(MenuSelection.this,MainActivity.class));
        }
        else
        {
            Toast.makeText(this, "For accessing chatbot login is must !!", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(MenuSelection.this,Login.class));
        }

    }



    public void specialistsName(View view) {

        Intent intent1 = new Intent(MenuSelection.this, SpecialistsNameActivity.class);
        startActivity(intent1);
    }

//    public void temporary(View view) {
////        String chatkey= databaseReference.push().getKey();
////        String chatkey2= databaseReference.push().getKey();
//
//        Intent intent1 = new Intent(MenuSelection.this, Temp_Doctor_Add.class);
//        startActivity(intent1);

//        doctorModel2=new DoctorModel("Dr. Md. Mozaffer Hossain","DA, FCPS ( Anaesthesiology )",
//                "Assistant Professor at Dhaka Medical College & Hospital","City Hospital Ltd",
//                "1/8, Block-E, Lalmatia, SatMasjid Road, Dhaka - 1217","+880-2-9124436");
//         doctorModel=new DoctorModel("Dr. Dilip Kumar Saha", "MBBS, DA, MD",
//                 "Associate Professor and Head at National Institute of ENT", "National Institute of ENT",
//                 "National Institute of ENT, Tejgaon, Dhaka","+880 1724665568");
        //doctorModel=new DoctorModel("","","", "","","");
//        databaseReference.child("DoctorList").child("OthersHospital").child("Anesthesiology").child(chatkey).setValue(doctorModel);
        //databaseReference.child("DoctorList").child("CityHospitalLtd").child("Anesthesiology").child(chatkey2).setValue(doctorModel2);

  //  }

    public void goToMedicineDetailsWeb(View view) {
        Intent intent1 = new Intent(MenuSelection.this, WebViewPage.class);
        startActivity(intent1);
    }

    public void hospitalDestails(View view) {
        Intent intent1 = new Intent(MenuSelection.this, NearbyHospitalMap.class);
        startActivity(intent1);
    }

    public void gotoEmergencyAmbulance(View view) {
        Intent intent1 = new Intent(MenuSelection.this, Ambulance.class);
        startActivity(intent1);
    }

    public void gotoBloodBank(View view) {
        Intent intent1 = new Intent(MenuSelection.this, BloodBank.class);
        startActivity(intent1);
    }



    //    public void callButton(View view) {
//        phoneNumber=doctorModel.getPhoneNo();
//        Intent callIntent = new Intent(Intent.ACTION_CALL);
//        callIntent.setData(Uri.parse(phoneNumber));
//        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
//            // TODO: Consider calling
//            //    ActivityCompat#requestPermissions
//            // here to request the missing permissions, and then overriding
//            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//            //                                          int[] grantResults)
//            // to handle the case where the user grants the permission. See the documentation
//            // for ActivityCompat#requestPermissions for more details.
//            return;
//        }
//        startActivity(callIntent);
//    }
}
