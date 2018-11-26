package com.example.admin.virtualdoctor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;

public class SpecialistsNameActivity extends AppCompatActivity {

    RecyclerView.Adapter adapter2;
    ArrayList<SpecialistsModel> list;
    ArrayList<String>list2;
    DatabaseReference databaseReference,databaseReference3;
    FirebaseDatabase firebaseDatabase;
    RecyclerView recyclerView;
    DoctorListAdapter adapter;
    SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specialists_name);

        searchView=findViewById(R.id.searchview);
        list=new ArrayList<SpecialistsModel>();
        list2=new ArrayList<String>();
        recyclerView=findViewById(R.id.docRecyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

//        databaseReference3=FirebaseDatabase.getInstance().getReference("DoctorList").child("type");
//        databaseReference3.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//
//                for(DataSnapshot dataSnapshot2: dataSnapshot.getChildren()) {
//                   // SpecialistsModel specialistsModel = dataSnapshot2.getValue(SpecialistsModel.class);
//                    String s = dataSnapshot2.getValue(String.class);
//                    list2.add(s);
//                    Toast.makeText(SpecialistsNameActivity.this, s, Toast.LENGTH_LONG).show();
////                    int newMsgPosition = list2.size() - 1;
////                    recyclerView.scrollToPosition(newMsgPosition);
//
//                }
////                adapter= new DoctorListAdapter(SpecialistsNameActivity.this,list2);
////                recyclerView.setAdapter(adapter);
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });

        list2.clear();
        list2.add("Anesthesiology Specialist");            list2.add("Burn Specialist");
        list2.add("Breast Surgeon Specialist");            list2.add("Cardiology Heart Specialist");
        list2.add("Cancer Specialist");                    list2.add("Cardiovascular Thoracic Surgeon");
        list2.add("Chest Asthma Specialist");              list2.add("Child Pediatric Cardiology");
        list2.add("Dental Specialist");                    list2.add("Dermatology Specialist");
        list2.add("Diabetes Specialist");                  list2.add("Eye Specialist");
        list2.add("ENT Specialist");                       list2.add("Gynaecology & Obstetrics Specialist");
        list2.add("Gastroenterology Specialist");          list2.add("Haematology Specialist");
        list2.add("Infertility Specialist");               list2.add("Kidney Specialist");
        list2.add("Liver Specialist");                     list2.add("Medicine Specialist");
        list2.add("Neuromedicine Specialist");             list2.add("Neuro Surgeons Specialist");
        list2.add("Nutritionist & Diet Specialist");       list2.add("Orthopaedics Specialist");
        list2.add("Pain Management Specialist");           list2.add("Pediatric Specialist");
        list2.add("Psychologist Specialist");              list2.add("Rheumatology Specialist");
        list2.add("Urology Specialist");

        adapter= new DoctorListAdapter(SpecialistsNameActivity.this,list2);
        recyclerView.setAdapter(adapter);



    }
}
