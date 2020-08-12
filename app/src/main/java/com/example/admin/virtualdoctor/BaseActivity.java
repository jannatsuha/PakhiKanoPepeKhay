package com.example.admin.virtualdoctor;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.provider.SyncStateContract;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.util.prefs.Preferences;

public class BaseActivity extends AppCompatActivity {

    public Toolbar toolbar;// Declaring the Toolbar Object
    private LoginPreferences loginPreferences;

    ActionBarDrawerToggle mDrawerToggle;
    Context context;
    Menu menu;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private android.support.v7.app.ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected boolean useToolbar() {
        return true;
    }


    @SuppressLint("ResourceAsColor")
    @Override
    public void setContentView(int layoutResID) {
        context = this;

        DrawerLayout fullView = (DrawerLayout) getLayoutInflater().inflate(R.layout.drawer_main, null);
        FrameLayout activityContainer = (FrameLayout) fullView.findViewById(R.id.frame);
        getLayoutInflater().inflate(layoutResID, activityContainer, true);

        super.setContentView(fullView);

         toolbar = (Toolbar) fullView.findViewById(R.id.tool_bar);


        loginPreferences = new LoginPreferences(this);

//        setSupportActionBar(toolbar);
       // getSupportActionBar().setTitle("Home");
        //toolbar.setTitle("Home");
//        this.getSupportActionBar().setElevation(0);

//        getSupportActionBar().setLogo(R.drawable.finalrobo3);
        //  toolbar.setLogo(R.drawable.ic_main);
//        if (useToolbar()) {
//          setSupportActionBar(toolbar);
//            setTitle("Places Near Me");
//        } else {
//            toolbar.setVisibility(View.GONE);
//        }

        //Initializing NavigationView
        navigationView = (NavigationView) findViewById(R.id.navigation_view);

        //Setting Navigation View Item Selected Listener to handle the item click of the navigation menu
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            // This method will trigger on item Click of navigation menu
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                //Checking if the item is in checked state or not, if not make it in checked state
                if (menuItem.isChecked()) menuItem.setChecked(false);
                else menuItem.setChecked(true);

                //Closing drawer on item click
                drawerLayout.closeDrawers();

                //Check to see which item was being clicked and perform appropriate action
                switch (menuItem.getItemId()) {
                    case R.id.nav_home:
                        startActivity(new Intent(BaseActivity.this,MenuSelection.class));
                        return true;
                    case R.id.nav_chatbot:
                        if (loginPreferences.getStatus())
                        {
                            startActivity(new Intent(BaseActivity.this,MainActivity.class));
                        }
                        else
                        {
                            Toast.makeText(context, "For accessing chatbot login is must !!", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(BaseActivity.this,Login.class));
                        }

                        return true;
                    case R.id.nav_specialists:
                        startActivity(new Intent(BaseActivity.this,SpecialistsNameActivity.class));
                        return true;
                    case R.id.nav_Hospitals:
                        startActivity(new Intent(BaseActivity.this,NearbyHospitalMap.class));
                        return true;
                    case R.id.nav_ambulance:
                        startActivity(new Intent(BaseActivity.this,Ambulance.class));
                        return true;
                    case R.id.nav_Bloodbank:
                        startActivity(new Intent(BaseActivity.this,BloodBank.class));
                        return true;
                    case R.id.nav_medicine:
                        startActivity(new Intent(BaseActivity.this,Medicine.class));
                        return true;
                    case R.id.nav_Signout:
                        FirebaseAuth.getInstance().signOut();
                        Intent intent1 = new Intent(BaseActivity.this, Login.class);
                        startActivity(intent1);
                        finish();
                        return true;
                    case R.id.nav_about_us:
                        return true;
                    default:
                        Toast.makeText(getApplicationContext(), "Work in progress", Toast.LENGTH_SHORT).show();
                        return true;
                }
            }
        });

        // Initializing Drawer Layout and ActionBarToggle
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        drawerLayout.setScrimColor(android.R.color.white);
        View header = navigationView.getHeaderView(0);


        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.openDrawer, R.string.closeDrawer) {

            @Override
            public void onDrawerClosed(View drawerView) {
                // Code here will be triggered once the drawer closes as we dont want anything to happen so we leave this blank
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };

        //Setting the actionbarToggle to drawer layout
        drawerLayout.setDrawerListener(actionBarDrawerToggle);

        //calling sync state is necessay or else your hamburger icon wont show up
        actionBarDrawerToggle.syncState();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        return mDrawerToggle.onOptionsItemSelected(item);
    }

    protected int getlayout()
    {
        return R.layout.drawer_main;
    }

    public String getTitleA()
    {
        return "";
    }
}
