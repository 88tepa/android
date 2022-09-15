package com.mkj.android_study_220829_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class Ex17IntentDataSend extends AppCompatActivity {
    String temp = "";//스피너 선택값 저장변수
    EditText etName;
    EditText etPhone;
    EditText etAdd;
    String dataName="홍길동";
    String dataAge="0";
    String dataPhone="010-";
    String dataAdd="0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex17_intent_data_send);

        ArrayList<String> items = new ArrayList<String>();
        for(int i=0; i<=200; i++){
            items.add(String.valueOf(i));
        }

        etName = (EditText) findViewById(R.id.etName);
        etPhone = (EditText) findViewById(R.id.etPhone);
        etAdd = (EditText) findViewById(R.id.etAdd);
        Spinner spinner = (Spinner) findViewById(R.id.spinnerAge);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, items
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // 스피너에 어댑터 설정
        spinner.setAdapter(adapter);

        // 스피너에서 선택 했을 경우 이벤트 처리
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                temp = items.get(position);
                Log.d("스피너테스트", "선택값 저장된 변수 temp : " + temp);

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                temp = "0";
            }
        });
        findViewById(R.id.btnSend).setOnClickListener(mClick);
    }

    View.OnClickListener mClick = new View.OnClickListener()
    {
        public void onClick(View v)
        {
            switch(v.getId())
            {
                case R.id.btnSend:
                    dataName=etName.getText().toString();
                    dataAge=temp;
                    dataPhone=etPhone.getText().toString();
                    dataAdd=etAdd.getText().toString();
                    Intent ex17 = new Intent(Ex17IntentDataSend.this, Ex17IntentDataReceive.class);
                    ex17.putExtra("dataName",dataName);
                    ex17.putExtra("dataAge",dataAge+"세");
                    ex17.putExtra("dataPhone",dataPhone);
                    ex17.putExtra("dataAdd",dataAdd);
                    startActivity(ex17);
                    break;
            }
        }
    };
}