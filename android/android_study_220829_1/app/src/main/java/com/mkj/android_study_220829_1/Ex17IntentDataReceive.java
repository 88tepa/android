package com.mkj.android_study_220829_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Ex17IntentDataReceive extends AppCompatActivity {
    TextView tvName, tvAge, tvPhone, tvAdd;

    String dataName, dataAge, dataPhone, dataAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex17_intent_data_receive);

        tvName = (TextView) findViewById(R.id.tvName);
        tvAge = (TextView) findViewById(R.id.tvAge);
        tvPhone = (TextView) findViewById(R.id.tvPhone);
        tvAdd = (TextView) findViewById(R.id.tvAdd);
        Intent getIntent = getIntent();
        dataName= getIntent.getStringExtra("dataName");
        dataAge= getIntent.getStringExtra("dataAge");
        dataPhone= getIntent.getStringExtra("dataPhone");
        dataAdd= getIntent.getStringExtra("dataAdd");

        tvName.setText(dataName);
        tvAge.setText(dataAge);
        tvPhone.setText(dataPhone);
        tvAdd.setText(dataAdd);

    }
}