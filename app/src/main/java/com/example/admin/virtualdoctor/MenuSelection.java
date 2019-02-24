package com.example.admin.virtualdoctor;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MenuSelection extends AppCompatActivity {


    ArrayList<String> list;
    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;
    DoctorModel doctorModel,doctorModel2,doctorModel3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_selection);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();

//        fdb = DataBaseUtil.getDatabase();

    }


    public void GoToChatbot(View view) {
        Intent intent1 = new Intent(MenuSelection.this, MainActivity.class);
        startActivity(intent1);
    }

    public void Signout(View view) {
        FirebaseAuth.getInstance().signOut();
        Intent intent1 = new Intent(MenuSelection.this, Login.class);
        startActivity(intent1);
        finish();
    }

    public void specialistsName(View view) {

        Intent intent1 = new Intent(MenuSelection.this, SpecialistsNameActivity.class);
        startActivity(intent1);
    }

    public void temporary(View view) {
//        String chatkey= databaseReference.push().getKey();
//        String chatkey2= databaseReference.push().getKey();

        Intent intent1 = new Intent(MenuSelection.this, Temp_Doctor_Add.class);
        startActivity(intent1);

//        doctorModel2=new DoctorModel("Dr. Md. Mozaffer Hossain","DA, FCPS ( Anaesthesiology )",
//                "Assistant Professor at Dhaka Medical College & Hospital","City Hospital Ltd",
//                "1/8, Block-E, Lalmatia, SatMasjid Road, Dhaka - 1217","+880-2-9124436");
//         doctorModel=new DoctorModel("Dr. Dilip Kumar Saha", "MBBS, DA, MD",
//                 "Associate Professor and Head at National Institute of ENT", "National Institute of ENT",
//                 "National Institute of ENT, Tejgaon, Dhaka","+880 1724665568");
        //doctorModel=new DoctorModel("","","", "","","");
//        databaseReference.child("DoctorList").child("OthersHospital").child("Anesthesiology").child(chatkey).setValue(doctorModel);
        //databaseReference.child("DoctorList").child("CityHospitalLtd").child("Anesthesiology").child(chatkey2).setValue(doctorModel2);

    }

    public void goToMedicineDetailsWeb(View view) {
        Intent intent1 = new Intent(MenuSelection.this, WebViewPage.class);
        startActivity(intent1);
    }
}
