package com.example.codehorizonapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.w3c.dom.Text;

public class VariablesActivity extends AppCompatActivity {

    public RadioGroup radioGroup;
    public Button submitBtn;
    int checkedId;
    String value = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_variables);

        radioGroup = (RadioGroup)findViewById(R.id.RadioGroup);
        submitBtn = (Button) findViewById(R.id.submit_btn);

        checkedId = radioGroup.getCheckedRadioButtonId();
        if(checkedId != -1) {
            value = ((RadioButton) findViewById(checkedId)).getText().toString();
        }

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(value == "Option One") {
                    // checking for right answer
                    Toast.makeText(VariablesActivity.this, "You chose the right answer", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}