package com.example.jinliyu.pictureinpictureexample;

import android.Manifest;
import android.app.PendingIntent;
import android.app.PictureInPictureParams;
import android.app.RemoteAction;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Point;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Rational;
import android.view.Display;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {


    private static final String TAG = MainActivity.class.getSimpleName();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    Display display = getWindowManager().getDefaultDisplay();
                    Point size = new Point();
                    display.getSize(size);
                    int width = size.x;
                    int height = size.y;

                    Rational aspectradio = new Rational(width, height);
                    PictureInPictureParams.Builder mPip = new PictureInPictureParams.Builder();
                    mPip.setAspectRatio(aspectradio).build();
                    enterPictureInPictureMode(mPip.build());
                }


            }
        });

    }

    @Override
    public void onPictureInPictureModeChanged(boolean isInPictureInPictureMode, Configuration newConfig) {
       if(isInPictureInPictureMode){
           if(getSupportActionBar() != null)
           getSupportActionBar().hide();
       }
        else {
           getSupportActionBar().show();
       }
    }
}

