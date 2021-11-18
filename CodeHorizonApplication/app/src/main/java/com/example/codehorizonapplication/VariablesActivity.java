package com.example.codehorizonapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import org.w3c.dom.Text;

public class VariablesActivity extends AppCompatActivity {

    public RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_variables);

        radioGroup = (RadioGroup)findViewById(R.id.RadioGroup);

        // getting value of radio button checked
        final String value = ((RadioButton)findViewById(radioGroup.getCheckedRadioButtonId())).getText().toString();


        if(radioGroup.getCheckedRadioButtonId() == -1){
            // no radio buttons checked
        } else{
            // one the radio buttons are checked
            Log.i("Radio Button Clicked", value);
        }
    }
}