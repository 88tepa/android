package com.mkj.android_study_220829_1;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class LogoActivity extends AppCompatActivity {

    Animation aniLogo;
    ImageView ivLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);

        ivLogo = (ImageView)findViewById(R.id.ivLogo);
        aniLogo = AnimationUtils.loadAnimation(LogoActivity.this, R.anim.test);

        ivLogo.startAnimation(aniLogo);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(LogoActivity.this,MainActivity.class);
                startActivity(intent); //딜레이 후 시작할 코드 작성
                finish();
            }
        }, 3000);
    }
}