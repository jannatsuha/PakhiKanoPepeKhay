package com.example.admin.virtualdoctor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Temp_Doctor_Add extends AppCompatActivity {

    EditText tChamber,tCatagory,tName,tDegree,tPosition,tChamberNmae,tchamberAddress,tPhoneNumber,tVisitTime,tFees;
    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;
    DoctorModel doctorModel;
    String chamberDatabase,catagoryDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp__doctor__add);
        tChamber=findViewById(R.id.chamber);
        tCatagory=findViewById(R.id.docCatagory);
        tName=findViewById(R.id.tempDocName);
        tDegree=findViewById(R.id.tempDegree);
        tPosition=findViewById(R.id.tempPosition);
        tChamberNmae=findViewById(R.id.tempChamber);
        tchamberAddress=findViewById(R.id.tempChamberAddress);
        tPhoneNumber=findViewById(R.id.tempContactNumber);
        tVisitTime=findViewById(R.id.tempVisitingTime);
        tFees=findViewById(R.id.tempVisiingFee);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
//        chamberDatabase=tChamber.getText().toString();
//        catagoryDatabase=tCatagory.getText().toString();
    }

    public void SaveDoctorDetails(View view) {
        String tempchatkey= databaseReference.push().getKey();
        doctorModel=new DoctorModel(tName.getText().toString(), tDegree.getText().toString(),
                tPosition.getText().toString(), tChamberNmae.getText().toString(),
                tchamberAddress.getText().toString(),tPhoneNumber.getText().toString(),tVisitTime.getText().toString(),tFees.getText().toString());
        databaseReference.child("DoctorList").child(tChamber.getText().toString()).child(tCatagory.getText().toString()).child(tempchatkey).setValue(doctorModel);
        Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();
        //tChamber.setText("");
        //tName.setText("");
        //tDegree.setText("");
        //tPosition.setText("");
        //tChamberNmae.setText("");
        //tchamberAddress.setText("");
       // tPhoneNumber.setText("+880");
    }
}
