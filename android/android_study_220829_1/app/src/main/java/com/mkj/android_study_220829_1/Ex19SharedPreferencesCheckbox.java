package com.mkj.android_study_220829_1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class Ex19SharedPreferencesCheckbox extends AppCompatActivity {

    private boolean saveLoginData;     // 아이디 저장
    private SharedPreferences appData; // 프리퍼런스

    String strId;                     // 문자 변수

    EditText etId;                     // 레이아웃 변수 EditText

    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex19_shared_preferences_checkbox);

        etId = (EditText) findViewById(R.id.etId);

        //내부적으로 저장되어있는 데이타가 있다면 가져오기
        //------------------------------------------------
        appData = getSharedPreferences("appData", MODE_PRIVATE);
        checkBox = (CheckBox) findViewById(R.id.checkBox);
        load();
        //------------------------------------------------

        checkBox.setOnClickListener(new CheckBox.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBox.isChecked()==true)
                {
                    Toast.makeText(getApplication(), "아이디저장 체크가 되었습니다.", Toast.LENGTH_SHORT).show();
                    saveId();
                }
                else
                {
                    Toast.makeText(getApplication(), "아이디저장 해제 되었습니다.", Toast.LENGTH_SHORT).show();
                    etId.setText("");
                }
            }
        }) ;
    }
    // 설정값을 저장하는 함수
    private void saveId() {
        // SharedPreferences 객체만으론 저장 불가능 Editor 사용
        SharedPreferences.Editor editor = appData.edit();

        // 에디터객체.put타입( 저장시킬 이름, 저장시킬 값 )
        // 저장시킬 이름이 이미 존재하면 덮어씌움
        editor.putBoolean("SAVE_LOGIN_DATA", checkBox.isChecked());
        editor.putString("ID", etId.getText().toString().trim());

        // apply, commit 을 안하면 변경된 내용이 저장되지 않음
        editor.apply();
    }
    // 설정값을 불러오는 함수
    private void load() {
        // SharedPreferences 객체.get타입( 저장된 이름, 기본값 )
        // 저장된 이름이 존재하지 않을 시 기본값
        saveLoginData = appData.getBoolean("SAVE_LOGIN_DATA", false);
        strId = appData.getString("ID", "");

        //체크박스가 체크되었던 값으로 기억시 체크됨.
        if(saveLoginData){checkBox.setChecked(true);}

        //처음로드시 값이 공백이면 무시 값이 있다면 아이디 가져와서 셋팅
        if(strId.equals("")) {
        }
        else {
            etId.setText(strId);
        }
    }
}