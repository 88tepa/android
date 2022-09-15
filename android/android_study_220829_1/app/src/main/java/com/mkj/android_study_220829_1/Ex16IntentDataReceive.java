package com.mkj.android_study_220829_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Ex16IntentDataReceive extends AppCompatActivity {
    TextView tvName, tvPrice;

    String data1, data2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex16_intent_data_receive);

        tvName = (TextView) findViewById(R.id.tvName);
        tvPrice = (TextView) findViewById(R.id.tvPrice);
        Intent getIntent = getIntent();
        data1= getIntent.getStringExtra("data1");
        data2= getIntent.getStringExtra("data2");

        tvName.setText(data1);
        tvPrice.setText(data2+"원");



    }
}