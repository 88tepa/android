package com.mkj.android_study_220829_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Ex10PhoneListActivity extends AppCompatActivity {

    EditText etNumber1, etNumber2, etNumber3, etNumber4, etNumber5, etNumber6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex10_phone_list);
        etNumber1 = findViewById(R.id.etNumber1);
        etNumber2 = findViewById(R.id.etNumber2);
        etNumber3 = findViewById(R.id.etNumber3);
        etNumber4 = findViewById(R.id.etNumber4);
        etNumber5 = findViewById(R.id.etNumber5);
        etNumber6 = findViewById(R.id.etNumber6);

        findViewById(R.id.btn1).setOnClickListener(mClick);
        findViewById(R.id.btn2).setOnClickListener(mClick);
        findViewById(R.id.btn3).setOnClickListener(mClick);
        findViewById(R.id.btn4).setOnClickListener(mClick);
        findViewById(R.id.btn5).setOnClickListener(mClick);
        findViewById(R.id.btn6).setOnClickListener(mClick);
        //전화번호 표시로 변경해주기
        etNumber1.addTextChangedListener(new PhoneNumberFormattingTextWatcher());
        etNumber2.addTextChangedListener(new PhoneNumberFormattingTextWatcher());
        etNumber3.addTextChangedListener(new PhoneNumberFormattingTextWatcher());
        etNumber4.addTextChangedListener(new PhoneNumberFormattingTextWatcher());
        etNumber5.addTextChangedListener(new PhoneNumberFormattingTextWatcher());
        etNumber6.addTextChangedListener(new PhoneNumberFormattingTextWatcher());
    }
    View.OnClickListener mClick = new View.OnClickListener()
    {
        public void onClick(View v)
        {
            String tel_number;
            Intent intent;
            switch(v.getId())
            {
                case R.id.btn1:
                    tel_number = "tel:"+etNumber1.getText().toString();
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse(tel_number));
                    startActivity(intent);
                    break;
                case R.id.btn2:
                    tel_number = "tel:"+etNumber2.getText().toString();
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse(tel_number));
                    startActivity(intent);
                    break;
                case R.id.btn3:
                    tel_number = "tel:"+etNumber3.getText().toString();
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse(tel_number));
                    startActivity(intent);
                    break;
                case R.id.btn4:
                    tel_number = "tel:"+etNumber4.getText().toString();
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse(tel_number));
                    startActivity(intent);
                    break;
                case R.id.btn5:
                    tel_number = "tel:"+etNumber5.getText().toString();
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse(tel_number));
                    startActivity(intent);
                    break;
                case R.id.btn6:
                    tel_number = "tel:"+etNumber6.getText().toString();
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse(tel_number));
                    startActivity(intent);
                    break;

            }
        }
    };
}