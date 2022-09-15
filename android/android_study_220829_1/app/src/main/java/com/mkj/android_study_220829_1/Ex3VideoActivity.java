package com.mkj.android_study_220829_1;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class Ex3VideoActivity extends AppCompatActivity {

    VideoView vv;
    Button btnPlay, btnIlsi, btnStop;
    Animation ani1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex3_video);
        vv = (VideoView)findViewById(R.id.videoView);

        btnPlay = findViewById(R.id.btnPlay);
        btnIlsi = findViewById(R.id.btnIlsi);
        btnStop = findViewById(R.id.btnStop);
        findViewById(R.id.btnPlay).setOnClickListener(mClick);
        findViewById(R.id.btnIlsi).setOnClickListener(mClick);
        findViewById(R.id.btnStop).setOnClickListener(mClick);
        Uri videoUri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.butterfly);
        vv.setMediaController(new MediaController(this));
        vv.setVideoURI(videoUri);
        ani1 = AnimationUtils.loadAnimation(Ex3VideoActivity.this, R.anim.touch);
    }
    View.OnClickListener mClick = new View.OnClickListener()
    {
        public void onClick(View v)
        {
            switch(v.getId())
            {
                case R.id.btnPlay:
                    btnPlay.startAnimation(ani1);
                    vv.start();
                    break;
                case R.id.btnIlsi:
                    btnIlsi.startAnimation(ani1);
                    vv.pause();
                    break;
                case R.id.btnStop:
                    btnStop.startAnimation(ani1);
                    vv.stopPlayback();
                    break;
            }
        }
    };
}