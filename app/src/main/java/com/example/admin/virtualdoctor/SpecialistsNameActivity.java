package com.example.admin.virtualdoctor;

import android.app.SearchManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.SearchView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;

public class SpecialistsNameActivity extends BaseActivity {

    RecyclerView.Adapter adapter2;
    DoctorListAdapter doctorListAdapter;
    ArrayList<SpecialistsModel> list;
    ArrayList<String>list2;
    DatabaseReference databaseReference,databaseReference3;
    FirebaseDatabase firebaseDatabase;
    RecyclerView recyclerView;
    DoctorListAdapter adapter;
    SearchView searchView;
    android.support.v7.widget.SearchView searchViews;
    private android.support.v7.app.ActionBar actionBar;
    static boolean scroll_down;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specialists_name);
        this.setTitle("All Specialists List");

        list=new ArrayList<SpecialistsModel>();
        list2=new ArrayList<String>();
        recyclerView=findViewById(R.id.docRecyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (scroll_down) {
                    getSupportActionBar().hide();
                } else {
                    getSupportActionBar().show();
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy > 70) {
                    //scroll down
                    scroll_down = true;

                } else if (dy < -5) {
                    //scroll up
                    scroll_down = false;
                }
            }
        });

        list2.clear();
        list2.add("Anesthesiology Specialist");            list2.add("Burn Specialist");
        list2.add("Breast Surgeon Specialist");            list2.add("Cardiology Heart Specialist");
        list2.add("Cancer Specialist");                    list2.add("Cardiovascular Thoracic Surgeon");
        list2.add("Chest Asthma Specialist");              list2.add("Child/Pediatric Specialist");
        list2.add("Dental Specialist");                    list2.add("Dermatology Specialist");
        list2.add("Diabetes Specialist");                  list2.add("Eye Specialist");
        list2.add("ENT Specialist");                       list2.add("Gynaecology & Obstetrics Specialist");
        list2.add("Gastroenterology Specialist");          list2.add("Haematology Specialist");
        list2.add("Nephrology Specialist");
        list2.add("Hepatology Specialist");                     list2.add("Medicine Specialist");
        list2.add("Neuromedicine Specialist");             list2.add("Neuro Surgeons Specialist");
        list2.add("Nutritionist & Diet Specialist");       list2.add("Orthopaedics Specialist");
        list2.add("Psychologist Specialist");              list2.add("Rheumatology Specialist");
        list2.add("Urology Specialist");

        adapter= new DoctorListAdapter(SpecialistsNameActivity.this,list2);
        recyclerView.setAdapter(adapter);
        doctorListAdapter= new DoctorListAdapter(SpecialistsNameActivity.this,list2);
        recyclerView.setAdapter(doctorListAdapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu,menu);
        SearchManager searchManager= (SearchManager) getSystemService(SEARCH_SERVICE);
        searchViews= (android.support.v7.widget.SearchView) menu.findItem(R.id.searchBox).getActionView();
        searchViews.setQueryHint("Search By Specialists type");
        searchViews.setSubmitButtonEnabled(true);
        searchViews.setOnQueryTextListener(new android.support.v7.widget.SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                doctorListAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                doctorListAdapter.getFilter().filter(newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

}
