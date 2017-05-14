package com.example.cgv.soundandvibration;

import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button b1, b2, b3, b4;
    Vibrator v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        b1 = (Button) findViewById(R.id.play);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertSound();
            }
        });

        b2 = (Button) findViewById(R.id.StpPlay);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StopSound();
            }
        });

        b3 = (Button) findViewById(R.id.Vibrate);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VibratePhone();
            }
        });

        b4 = (Button) findViewById(R.id.StpVib);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StopVibrate();
            }
        });

    }


    private void AlertSound() {
        startService(new Intent(this, ServiceActivity.class));
        Toast toast = Toast.makeText(getApplicationContext(), "Obstacle Ahead", Toast.LENGTH_SHORT);
        toast.show();
    }

    private void StopSound() {
        stopService(new Intent(this, ServiceActivity.class));
    }

    private void VibratePhone() {
        v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        long[] pattern = {0, 1000, 1000};
        v.vibrate(pattern, 0);
        Toast toast = Toast.makeText(getApplicationContext(), "Obstacle Ahead", Toast.LENGTH_SHORT);
        toast.show();
    }

    private void StopVibrate() {
        v.cancel();
    }


}
