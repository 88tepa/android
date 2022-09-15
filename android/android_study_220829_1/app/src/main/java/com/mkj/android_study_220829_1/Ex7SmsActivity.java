package com.mkj.android_study_220829_1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Ex7SmsActivity extends AppCompatActivity {

    EditText etNumber;
    EditText etmMessage;
    Button btnSend;

    String history = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex7_sms);
        etNumber = findViewById(R.id.etNumber);
        etmMessage = findViewById(R.id.etmMessage);
        btnSend = findViewById(R.id.btnSend);

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
        findViewById(R.id.btnSend).setOnClickListener(mClick);
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
                    Toast.makeText(Ex7SmsActivity.this, delNumber, Toast.LENGTH_SHORT).show();
                    etNumber.setText(delNumber.substring(0,delNumber.length()-1));
                    break;
                case R.id.btnSend:
                    String phoneNo = "tel:"+etNumber.getText().toString();
                    String message = etmMessage.getText().toString();
                    if (phoneNo.length()>0 && message.length()>0)
                        sendSMS(phoneNo, message);
                    else
                        Toast.makeText(getBaseContext(),
                            "Please enter both phone number and message.",
                        Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };
    // SMS를 전송하는 과정을 모니터링하고 싶다면
    private void sendSMS(String phoneNumber, String message)
    {
        String SENT = "SMS_SENT";
        String DELIVERED = "SMS_DELIVERED";

        PendingIntent sentPI = PendingIntent.getBroadcast(this, 0,
                new Intent(SENT), 0);

        PendingIntent deliveredPI = PendingIntent.getBroadcast(this, 0,
                new Intent(DELIVERED), 0);

        //---when the SMS has been sent---
        registerReceiver(new BroadcastReceiver(){
            @Override
            public void onReceive(Context arg0, Intent arg1) {
            switch (getResultCode())
            {
                case Activity.RESULT_OK:
                    Toast.makeText(getBaseContext(), "SMS sent",
                            Toast.LENGTH_SHORT).show();
                    break;
                case SmsManager.RESULT_ERROR_GENERIC_FAILURE:
                    Toast.makeText(getBaseContext(), "Generic failure",
                            Toast.LENGTH_SHORT).show();
                    break;
                case SmsManager.RESULT_ERROR_NO_SERVICE:
                    Toast.makeText(getBaseContext(), "No service",
                            Toast.LENGTH_SHORT).show();
                    break;
                case SmsManager.RESULT_ERROR_NULL_PDU:
                    Toast.makeText(getBaseContext(), "Null PDU",
                            Toast.LENGTH_SHORT).show();
                    break;
                case SmsManager.RESULT_ERROR_RADIO_OFF:
                    Toast.makeText(getBaseContext(), "Radio off",
                            Toast.LENGTH_SHORT).show();
                    break;
            }
            }
        }, new IntentFilter(SENT));

        //---when the SMS has been delivered---
        registerReceiver(new BroadcastReceiver(){
            @Override
            public void onReceive(Context arg0, Intent arg1) {
            switch (getResultCode())
            {
                case Activity.RESULT_OK:
                    Toast.makeText(getBaseContext(), "SMS delivered",
                            Toast.LENGTH_SHORT).show();
                    break;
                case Activity.RESULT_CANCELED:
                    Toast.makeText(getBaseContext(), "SMS not delivered",
                            Toast.LENGTH_SHORT).show();
                    break;
            }
            }
        }, new IntentFilter(DELIVERED));

        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(phoneNumber, null, message, sentPI, deliveredPI);
    }

    // 모니터링 안하고 발송을 원한다면 아래 함수를 이용
    private void __sendSMS(String phoneNumber, String message)
    {
        PendingIntent pi = PendingIntent.getActivity(this, 0,
                new Intent(this, Ex7SmsActivity.class), 0);
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(phoneNumber, null, message, pi, null);
    }
}