package com.programhorizon.timersdemo;

import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new CountDownTimer(10000, 1000){
            public void onTick(long millisecondsUntilDone){
                // During counter (every second)

                Log.i("Seconds Left", String.valueOf(millisecondsUntilDone / 1000));
            }

            public void onFinish(){
                // counter is finished
                Log.i("Done", "Counter done");
            }
        }.start();
    }

        /*
        final Handler handler = new Handler();
        Runnable run = new Runnable() {
            @Override
            public void run() {
                // Insert code to be ran every second

                Log.i("Runnable has run", "a second has passed");

                handler.postDelayed(this, 1000); // this refers to run method
            }
        };

        handler.post(run); // executing runnable from start

    }
    */
}
