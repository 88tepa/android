package com.mkj.android_study_220829_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class Ex2GifActivity extends AppCompatActivity {

    ImageView ivBanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex2_gif);
        ivBanner = (ImageView) findViewById(R.id.ivGif1);

        Glide.with(Ex2GifActivity.this).load(R.drawable.unique_warm_carp_size_restricted).into(ivBanner);
    }
}