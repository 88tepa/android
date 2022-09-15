package com.mkj.android_study_220829_1;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;

public class Ex4MediaActivity extends AppCompatActivity {

    Animation ani1;
    MediaPlayer player, player1, player2;
    ImageButton btnPlay, btnIlsi, btnStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex4_meadia);
        player1 = MediaPlayer.create(Ex4MediaActivity.this, R.raw.howls_moving_castle);
        player2 = MediaPlayer.create(Ex4MediaActivity.this, R.raw.hahyunwoo_jilpoong);

        btnPlay = findViewById(R.id.btnPlay);
        btnIlsi = findViewById(R.id.btnIlsi);
        btnStop = findViewById(R.id.btnStop);
        findViewById(R.id.btnPlay).setOnClickListener(mClick);
        findViewById(R.id.btnIlsi).setOnClickListener(mClick);
        findViewById(R.id.btnStop).setOnClickListener(mClick);
        ani1 = AnimationUtils.loadAnimation(Ex4MediaActivity.this, R.anim.touch);
    }
    View.OnClickListener mClick = new View.OnClickListener()
    {
        public void onClick(View v)
        {
            switch(v.getId())
            {
                case R.id.btnPlay:
                    btnPlay.startAnimation(ani1);
                    player1.start();
                    break;
                case R.id.btnIlsi:
                    btnIlsi.startAnimation(ani1);
                    player1.pause();
                    break;
                case R.id.btnStop:
                    btnStop.startAnimation(ani1);
                    player1.stop();
                    break;

            }
        }
    };
}