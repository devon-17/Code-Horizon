package com.example.codehorizonapplication;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class HomeActivity extends AppCompatActivity {

    public Button signOutBtn;
    public Button overviewBtn;
    public Button varBtn;
    FirebaseAuth auth;
    boolean overviewDone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        signOutBtn = findViewById(R.id.signOutBtn);
        overviewBtn = findViewById(R.id.overviewBtn);
        varBtn = findViewById(R.id.varBtn);
        auth = FirebaseAuth.getInstance();

        overviewDone = false;

        signOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                auth.signOut();
                startActivity(new Intent(HomeActivity.this, SignInActivity.class));
                finish();
            }
        });

        overviewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent overviewBtnIntent = new Intent(HomeActivity.this, OverviewActivity.class);
                startActivity(overviewBtnIntent);
            }
        });

        if (getIntent().hasExtra("state")) {
            if (getIntent().getStringExtra("state").equals("enable")) {
                overviewDone = true;
                varBtn.setEnabled(true);
            } else {
                varBtn.setEnabled(false);
            }
        } else {
            varBtn.setEnabled(false);
        }

        varBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent varbiesButtonIntent = new Intent(HomeActivity.this, VariablesActivity.class);
                startActivity(varbiesButtonIntent);
                Log.i("Variable Button", "Going to Variable Activity");
            }
        });
    }
}