package com.mkj.android_study_220829_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Ex5WebViewActivity extends AppCompatActivity {

    TextView tvMsg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex5_web_view);
        tvMsg = (TextView)findViewById(R.id.tvMsg);

        findViewById(R.id.btn1).setOnClickListener(mClick);
        findViewById(R.id.btn2).setOnClickListener(mClick);
        findViewById(R.id.btn3).setOnClickListener(mClick);
        findViewById(R.id.btn4).setOnClickListener(mClick);
    }

    View.OnClickListener mClick = new View.OnClickListener()
    {
        public void onClick(View v)
        {
            switch(v.getId())
            {
                case R.id.btn1:
                    tvMsg.setText("구글 접속!");
                    Intent act1 = new Intent(Ex5WebViewActivity.this, Ex5WebViewExGoogle.class);
                    startActivity(act1);
                    break;
                case R.id.btn2:
                    tvMsg.setText("유튜브접속!");
                    Intent act2 = new Intent(Ex5WebViewActivity.this, Ex5WebViewExYoutube.class);
                    startActivity(act2);
                    break;
                case R.id.btn3:
                    tvMsg.setText("네이버접속함");
                    Intent act3 = new Intent(Ex5WebViewActivity.this, Ex5WebViewExNaver.class);
                    startActivity(act3);
                    break;
                case R.id.btn4:
                    tvMsg.setText("스팀접속함");
                    Intent act4 = new Intent(Ex5WebViewActivity.this, Ex5WebViewExSteam.class);
                    startActivity(act4);
                    break;
            }
        }
    };
}