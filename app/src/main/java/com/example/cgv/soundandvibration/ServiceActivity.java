package com.example.cgv.soundandvibration;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ServiceActivity extends Service {

    private MediaPlayer Alert;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public ServiceActivity() {
        super();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //return super.onStartCommand(intent, flags, startId);
        Alert = MediaPlayer.create (this, R.raw.alert);
        Alert.setLooping(true);
        Alert.start();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Alert.stop();
    }
}
