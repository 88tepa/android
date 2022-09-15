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

public class Ex6TelActivity extends AppCompatActivity {

    EditText etNumber;
    Button btnCall;

    String history = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex6_tel);
        etNumber = findViewById(R.id.etNumber);
        btnCall = findViewById(R.id.btnCall);

        findViewById(R.id.btn0).setOnClickListener(mClick);
        findViewById(R.id.btn1).setOnClickListener(mClick);
        findViewById(R.id.btn2).setOnClickListener(mClick);
        findViewById(R.id.btn3).setOnClickListener(mClick);
        findViewById(R.id.btn4).setOnClickListener(mClick);
        findViewById(R.id.btn5).setOnClickListener(mClick);
        findViewById(R.id.btn6).setOnClickListener(mClick);
        findViewById(R.id.btn7).setOnClickListener(mClick);
        findViewById(R.id.btn8).setOnClickListener(mClick);
        findViewById(R.id.btn9).setOnClickListener(mClick);
        findViewById(R.id.btnStar).setOnClickListener(mClick);
        findViewById(R.id.btnSharp).setOnClickListener(mClick);
        findViewById(R.id.btnDel).setOnClickListener(mClick);
        findViewById(R.id.btnCall).setOnClickListener(mClick);
        //전화번호 표시로 변경해주기
        etNumber.addTextChangedListener(new PhoneNumberFormattingTextWatcher());
    }
    View.OnClickListener mClick = new View.OnClickListener()
    {
        public void onClick(View v)
        {
            switch(v.getId())
            {
                case R.id.btn1:
                    etNumber.setText(etNumber.getText().toString()+"1");
                    break;
                case R.id.btn2:
                    etNumber.setText(etNumber.getText().toString()+"2");
                    break;
                case R.id.btn3:
                    etNumber.setText(etNumber.getText().toString()+"3");
                    break;
                case R.id.btn4:
                    etNumber.setText(etNumber.getText().toString()+"4");
                    break;
                case R.id.btn5:
                    etNumber.setText(etNumber.getText().toString()+"5");
                    break;
                case R.id.btn6:
                    etNumber.setText(etNumber.getText().toString()+"6");
                    break;
                case R.id.btn7:
                    etNumber.setText(etNumber.getText().toString()+"7");
                    break;
                case R.id.btn8:
                    etNumber.setText(etNumber.getText().toString()+"8");
                    break;
                case R.id.btn9:
                    etNumber.setText(etNumber.getText().toString()+"9");
                    break;
                case R.id.btn0:
                    etNumber.setText(etNumber.getText().toString()+"0");
                    break;
                case R.id.btnStar:
                    etNumber.setText(etNumber.getText().toString()+"*");
                    break;
                case R.id.btnSharp:
                    etNumber.setText(etNumber.getText().toString()+"#");
                    break;
                case R.id.btnDel:
                    String delNumber = etNumber.getText().toString();
                    Toast.makeText(Ex6TelActivity.this, delNumber, Toast.LENGTH_SHORT).show();
                    etNumber.setText(delNumber.substring(0,delNumber.length()-1));
                    break;
                case R.id.btnCall:
                    String tel_number = "tel:"+etNumber.getText().toString();

                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(tel_number));
                    startActivity(intent);
                    break;
            }
        }
    };
}