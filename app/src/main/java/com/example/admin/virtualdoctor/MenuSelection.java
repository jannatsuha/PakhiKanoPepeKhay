package com.example.admin.virtualdoctor;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MenuSelection extends AppCompatActivity {

    private FirebaseDatabase fdb;
    private FirebaseAuth mAuth;
    ArrayList<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_selection);
        fdb = DataBaseUtil.getDatabase();

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
}
