package com.mkj.android_study_220829_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class Ex9ImageViewExActivity extends AppCompatActivity {

    ImageView ivImg1, ivImg2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex9_image_view_ex);

        ivImg2 = (ImageView)findViewById(R.id.ivImg2);

        findViewById(R.id.ivImg1).setOnClickListener(mClick);
    }
    View.OnClickListener mClick = new View.OnClickListener()
    {
        public void onClick(View v)
        {
            switch(v.getId())
            {
                case R.id.ivImg1:
                    ivImg2.setImageResource(R.drawable.img_559_314);
                    Toast.makeText(Ex9ImageViewExActivity.this,"아래이미지 복사변경!",Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };
}