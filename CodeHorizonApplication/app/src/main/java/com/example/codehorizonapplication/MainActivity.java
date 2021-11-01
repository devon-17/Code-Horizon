package com.example.codehorizonapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private EditText signEmail, signPass;
    private TextView signText;
    private Button signBtn;

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        signEmail = findViewById(R.id.email_sign);
        signPass = findViewById(R.id.pass_sign);
        signText = findViewById(R.id.signInText);
        signBtn = findViewById(R.id.sign_btn);

        auth = FirebaseAuth.getInstance();


        signText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SignInActivity.class));
            }
        });

        signBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { createUser(); }
        });

    }

    private void createUser(){
        String email = signEmail.getText().toString();
        String pass = signPass.getText().toString();

        if (!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            if(!pass.isEmpty()){

                auth.createUserWithEmailAndPassword(email, pass)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Toast.makeText(MainActivity.this, "Registered Successfully!", Toast.LENGTH_LONG).show();
                                startActivity(new Intent(MainActivity.this, SignInActivity.class));
                                finish();
                                Log.i("Registration", "REGISTRATION SUCCESS");
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this, "Sign Up Error, Try Again", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(MainActivity.this, MainActivity.class));
                    }
                });

            }else{
                signPass.setError("Empty Field Not Allowed");
            }
        }else if(email.isEmpty()){
            signEmail.setError("Empty Field Not Allowed");
        }else{
            signEmail.setError("Please Enter A Valid Email");
        }
    }
}