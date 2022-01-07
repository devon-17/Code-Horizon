package com.programhorizon.eggtimer;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SeekBar timerSeekBar;
    TextView timerText;
    Button controllerButton;
    Boolean counterIsActive = false;
    CountDownTimer countdownTimer;

    public void updateTimer(int secondsLeft){

        int mins = secondsLeft / 60; // turning progress into minutes
        int seconds = secondsLeft - mins * 60;

        String secondsString = Integer.toString(seconds);

        // if timer ends in "0" for seconds change it to where there is two zeros instead of one
        if (seconds <= 9){
            secondsString = "0" + secondsString;
        }

        timerText = (TextView)findViewById(R.id.timerTextView);

        timerText.setText(Integer.toString(mins) + ":" + secondsString); // turning ints to text
    }

    public void resetTimer(){
        timerText.setText("0:00");
        timerSeekBar.setProgress(30);
        countdownTimer.cancel();
        controllerButton.setText("GO!");
        timerSeekBar.setEnabled(true);
        counterIsActive = false;
    }

    public void controlTimer(View v){

        if(counterIsActive == false) {


            counterIsActive = true;
            timerSeekBar.setEnabled(false);
            controllerButton.setText("STOP");

            countdownTimer = new CountDownTimer(timerSeekBar.getProgress() * 1000 + 100, 1000) {

                @Override
                public void onTick(long millisUntilFinished) {

                    updateTimer((int) millisUntilFinished / 1000); // casting to int then divided by 1000 to get seconds

                }

                @Override
                public void onFinish() {

                    timerText.setText("0:00");
                    Log.i("Finished", "Timer done");
                    MediaPlayer mPlayer = MediaPlayer.create(getApplicationContext(), R.raw.swish_2); // put getApplicationContext because it is in a function
                    mPlayer.start();
                    resetTimer();
                }
            }.start();
        } else{
            resetTimer();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timerSeekBar = (SeekBar)findViewById(R.id.timerSeekBar);
        timerSeekBar.setMax(600); // in seconds so 10 minutes
        timerSeekBar.setProgress(30); // start progress at 30 seconds

        controllerButton = (Button)findViewById(R.id.controllerButton);

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
