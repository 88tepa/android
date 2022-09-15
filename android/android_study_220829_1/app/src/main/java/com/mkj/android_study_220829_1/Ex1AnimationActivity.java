package com.mkj.android_study_220829_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Ex1AnimationActivity extends AppCompatActivity {

    Animation ani1, ani2, ani3, ani4;
    ImageView ivLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex1_animation);

        ivLogo = (ImageView)findViewById(R.id.ivLogo);
        findViewById(R.id.btn1).setOnClickListener(mClick);
        findViewById(R.id.btn2).setOnClickListener(mClick);
        findViewById(R.id.btn3).setOnClickListener(mClick);
        findViewById(R.id.btn4).setOnClickListener(mClick);

        ani1 = AnimationUtils.loadAnimation(Ex1AnimationActivity.this, R.anim.test);
        ani2 = AnimationUtils.loadAnimation(Ex1AnimationActivity.this, R.anim.test2);
        ani3 = AnimationUtils.loadAnimation(Ex1AnimationActivity.this, R.anim.test3);
        ani4 = AnimationUtils.loadAnimation(Ex1AnimationActivity.this, R.anim.test4);
    }
    View.OnClickListener mClick = new View.OnClickListener()
    {
        public void onClick(View v)
        {
            switch(v.getId())
            {
                case R.id.btn1:
                    ivLogo.startAnimation(ani1);
                    break;
                case R.id.btn2:
                    ivLogo.startAnimation(ani2);
                    break;
                case R.id.btn3:
                    ivLogo.startAnimation(ani3);
                    break;
                case R.id.btn4:
                    ivLogo.startAnimation(ani4);
                    break;
            }
        }
    };
}