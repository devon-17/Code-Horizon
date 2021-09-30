package com.programhorizon.eggtimer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SeekBar timerSeekBar;
    TextView timerText;

    public void updateTimer(int secondsLeft){

        int mins = secondsLeft / 60; // turning progress into minutes
        int seconds = secondsLeft - mins * 60;

        String secondsString = Integer.toString(seconds);

        // if timer ends in "0" for seconds change it to where there is two zeros instead of one
        if(secondsString == "0"){
            secondsString = "00";
        }

        timerText = (TextView)findViewById(R.id.timerTextView);

        timerText.setText(Integer.toString(mins) + ":" + secondsString); // turning ints to text
    }

    public void controlTimer(View v){

        new CountDownTimer(timerSeekBar.getProgress() * 1000, 1000){

            @Override
            public void onTick(long millisUntilFinished){

                updateTimer((int) millisUntilFinished / 1000); // casting to int then divided by 1000 to get seconds

            }

            @Override
            public void onFinish(){

                Log.i("Finished", "Timer done");

            }
        }.start();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timerSeekBar = (SeekBar)findViewById(R.id.timerSeekBar);
        timerSeekBar.setMax(600); // in seconds so 10 minutes
        timerSeekBar.setProgress(30); // start progress at 30 seconds

        timerSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                updateTimer(progress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}
