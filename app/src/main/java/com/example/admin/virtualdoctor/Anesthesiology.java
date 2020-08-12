package com.example.admin.virtualdoctor;

import android.app.SearchManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import com.ethanhua.skeleton.SkeletonScreen;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;

public class Anesthesiology extends BaseActivity {

    DatabaseReference databaseReference,databaseReference2;
    FirebaseDatabase firebaseDatabase;
    RecyclerView recyclerView;
    SkeletonScreen skeletonScreen;
    private ArrayList<String>list2;
    private ArrayList<DoctorModel> list1;
    private DoctorShowAdapter doctorShowAdapter,doctorShowAdapter2;
    android.support.v7.widget.SearchView searchViews;
    static boolean scroll_down;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anesthesiology);
        this.setTitle("Anesthesiologists");

        recyclerView=findViewById(R.id.anestheDocRecyclerview);

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

        list2=new ArrayList<String>();
        list1 = new ArrayList<DoctorModel>();
        list2=Singleton.getInstance().getFrameList();

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


                    doctorShowAdapter = new DoctorShowAdapter(Anesthesiology.this, list1);
                    recyclerView.setAdapter(doctorShowAdapter);

                }
                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
        doctorShowAdapter2= new DoctorShowAdapter(Anesthesiology.this,list1);
        recyclerView.setAdapter(doctorShowAdapter2);


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu,menu);
        SearchManager searchManager= (SearchManager) getSystemService(SEARCH_SERVICE);
        searchViews= (android.support.v7.widget.SearchView) menu.findItem(R.id.searchBox).getActionView();
        searchViews.setQueryHint("Search By Doctor Name");
        searchViews.setSubmitButtonEnabled(true);
        searchViews.setOnQueryTextListener(new android.support.v7.widget.SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
               // Toast.makeText(Anesthesiology.this, " "+query, Toast.LENGTH_SHORT).show();
                doctorShowAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
               // Toast.makeText(Anesthesiology.this, " "+newText, Toast.LENGTH_SHORT).show();
                doctorShowAdapter.getFilter().filter(newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

//    private void setEventRecyclerView(ArrayList<DoctorModel> doctorModelslist) {
//
//        doctorShowAdapter2 = new DoctorShowAdapter(doctorModelslist, Context);
//        skeletonScreen = Skeleton.bind(mEventRecyclerView)
//                .adapter(allEventAdapter)
//                .load(R.layout.item_skeleton_news)
//                .show();
//
//        mEventRecyclerView.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                skeletonScreen.hide();
//            }
//        }, 1000);
//
//        //mEventRecyclerView.setAdapter(allEventAdapter);
//        //allEventAdapter.notifyDataSetChanged();
//    }
}
