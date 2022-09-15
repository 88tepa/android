package com.mkj.android_study_220829_1;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Ex13PhoneList2Activity extends AppCompatActivity {
    private String TAG = "리스트뷰예제";
    private ListView listview = null;
    private ListViewAdapter adapter = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex13_phone_list2);

        listview = (ListView) findViewById(R.id.listView);
        adapter = new ListViewAdapter();

        //Adapter 안에 아이템의 정보 담기
        adapter.addItem(new Ex13PhoneList2Item(R.drawable.honggildong, "홍길동", "010-1111-2222", R.drawable.call));
        adapter.addItem(new Ex13PhoneList2Item(R.drawable.dooly, "둘리", "010-1111-3333", R.drawable.call));
        adapter.addItem(new Ex13PhoneList2Item(R.drawable.gogildong, "고길동", "010-1111-4444", R.drawable.call));
        adapter.addItem(new Ex13PhoneList2Item(R.drawable.douner, "도우너", "010-1111-5555", R.drawable.call));
        adapter.addItem(new Ex13PhoneList2Item(R.drawable.ddochi, "또치", "010-1111-6666", R.drawable.call));
        adapter.addItem(new Ex13PhoneList2Item(R.drawable.michol, "마이콜", "010-1111-7777", R.drawable.call));

        //리스트뷰에 Adapter 설정
        listview.setAdapter(adapter);
    }


    /* 리스트뷰 어댑터 */
    public class ListViewAdapter extends BaseAdapter {
        ArrayList<Ex13PhoneList2Item> items = new ArrayList<Ex13PhoneList2Item>();

        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(Ex13PhoneList2Item item) {
            items.add(item);
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup viewGroup) {
            final Context context = viewGroup.getContext();
            final Ex13PhoneList2Item callItem = items.get(position);

            if(convertView == null) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.activity_ex13_phone_list2_item, viewGroup, false);

            } else {
                View view = new View(context);
                view = (View) convertView;
            }

            ImageView iv_icon = (ImageView) convertView.findViewById(R.id.ivImg);
            TextView tv_name = (TextView) convertView.findViewById(R.id.tvName);
            TextView tv_num = (TextView) convertView.findViewById(R.id.tvNum);
            ImageView iv_call = (ImageView) convertView.findViewById(R.id.ivCall);

            iv_icon.setImageResource(callItem.getResId());
            tv_name.setText(callItem.getName());
            tv_num.setText(callItem.getNum());
            iv_call.setImageResource(callItem.getResIdBtn());

            Log.d(TAG, "getView() - [ "+position+" ] "+callItem.getName());

            //각 아이템 선택 event
            iv_call.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, callItem.getNum()+" 번 - "+callItem.getName()+" 입니당! ", Toast.LENGTH_SHORT).show();
                    String tel_number = "tel:"+callItem.getNum();
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(tel_number));
                    startActivity(intent);
                }
            });
            return convertView;  //뷰 객체 반환
        }
    }
}