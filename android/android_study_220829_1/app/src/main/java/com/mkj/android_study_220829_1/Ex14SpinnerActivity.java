package com.mkj.android_study_220829_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class Ex14SpinnerActivity extends AppCompatActivity {

    TextView textView;

    String[] items = {
            "선택되지않음",
            "건담",
            "Z건담",
            "하이뉴 건담",
            "유니콘 건담",
            "갓 건담",
            "윙 제로 건담",
            "스트라이크 프리덤 건담",
            "더블오 라이저",
            "건담 발바토스 루프스 렉스",
            "건담 어스트레이 레드 프레임 改",
            "건담 어스트레이 블루 프레임 세컨드 R"};

    //이미지 배열만들거야
    Integer[] pics = {
            R.drawable.sd_gundam_battle_alliance_unknown,
            R.drawable.sd_gundam_battle_alliance_gundam,
            R.drawable.sd_gundam_battle_alliance_zeta_gundam,
            R.drawable.sd_gundam_battle_alliance_hi_nu_gundam,
            R.drawable.sd_gundam_battle_alliance_unicorn_gundam,
            R.drawable.sd_gundam_battle_alliance_god_gundam,
            R.drawable.sd_gundam_battle_alliance_wing_zero_gundam,
            R.drawable.sd_gundam_battle_alliance_strike_freedom_gundam,
            R.drawable.sd_gundam_battle_alliance_oo_raiser,
            R.drawable.sd_gundam_battle_alliance_gundam_barbatos_lupus_rex,
            R.drawable.sd_gundam_battle_alliance_gundam_astray_red_frame_kai,
            R.drawable.sd_gundam_battle_alliance_gundam_astray_blue_frame_second_revise}; //왜 상수로 만들어야하는지?

    ImageView ivImg;

    String temp = ""; //스피너 선택값 저장변수

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex14_spinner);

        textView = (TextView) findViewById(R.id.tvSel);

        ivImg = (ImageView) findViewById(R.id.ivImg);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
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
                textView.setText(items[position]);

                ivImg.setImageResource(pics[position]);

                temp = items[position];
                Log.d("스피너테스트", "선택값 저장된 변수 temp : " + temp);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                textView.setText("선택 : ");
            }
        });

    }
}