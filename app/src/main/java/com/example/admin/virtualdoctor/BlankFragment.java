package com.example.admin.virtualdoctor;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class BlankFragment extends Fragment {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;


    public BlankFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    RecyclerView recyclerView;
    DoctorShowAdapter doctorShowAdapter,doctorShowAdapter2;
    public ArrayList<String> list2;
    ArrayList<DoctorModel> list1,list3;
    DatabaseReference databaseReference,databaseReference2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.activity_anesthesiology, container, false);
        recyclerView=view.findViewById(R.id.anestheDocRecyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        list1 = new ArrayList<DoctorModel>();
        list2=new ArrayList<String>();
        list2.add("SquareHospitalLtd");

        list1.clear();
        for(int i=0;i<=list2.size()-1;i++) {
            String s= list2.get(i);
            databaseReference2 = FirebaseDatabase.getInstance().getReference().child("DoctorList").child(s).child("Anesthesiology");
            databaseReference2.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {


                    for (DataSnapshot dataSnapshot2 : dataSnapshot.getChildren()) {
                        DoctorModel doctorModel = dataSnapshot2.getValue(DoctorModel.class);
                        list1.add(doctorModel);
                    }

                    doctorShowAdapter = new DoctorShowAdapter(getActivity(), list1);
                    recyclerView.setAdapter(doctorShowAdapter);
                }
                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }

        return view;
    }



}
