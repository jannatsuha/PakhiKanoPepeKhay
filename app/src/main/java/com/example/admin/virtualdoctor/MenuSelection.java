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
    DoctorModel doctorModel;



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
        String chatkey= databaseReference.push().getKey();
       // doctorModel=new DoctorModel("Dr. Shah Muhammad Ali","MBBS, FCPS","Consultant at SQUARE Hospitals Ltd","SQUARE Hospitals Ltd","18/F West Panthapath, Dhaka - 1205, Bangladesh","+880-2-8159457");
        // doctorModel=new DoctorModel("Professor Dr. Kazi Mesbahuddin lqbal","MBBS, DA, FFARCS (Ireland), FRCA (USA)","Coordinator & Senior Consultant at Apollo Hospitals Dhaka", " Apollo Hospitals Dhaka","Plot # 81, Block # E, Basudhara R/A, Dhaka - 1229","+880-2-8401661");
        //doctorModel=new DoctorModel("","","", "","","");
       // databaseReference.child("DoctorList").child("ApolloHospitalDhaka").child("Anesthesiology").child(chatkey).setValue(doctorModel);

    }
}
