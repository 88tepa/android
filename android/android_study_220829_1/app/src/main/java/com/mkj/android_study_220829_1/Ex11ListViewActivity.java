package com.mkj.android_study_220829_1;

import android.content.Context;
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

public class Ex11ListViewActivity extends AppCompatActivity {
    private String TAG = "리스트뷰예제";
    private ListView listview = null;
    private ListViewAdapter adapter = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex11_list_view);

        listview = (ListView) findViewById(R.id.listView);
        adapter = new ListViewAdapter();

        //Adapter 안에 아이템의 정보 담기
        adapter.addItem(new Ex11ListViewItem("1", "암컷 피카츄", R.drawable.pikachu_female));
        adapter.addItem(new Ex11ListViewItem("2", "닥터 피카츄", R.drawable.pikachu_doctor));
        adapter.addItem(new Ex11ListViewItem("3", "하드록 피카츄", R.drawable.pikachu_hardrock));
        adapter.addItem(new Ex11ListViewItem("4", "아이돌 피카츄", R.drawable.pikachu_idol));
        adapter.addItem(new Ex11ListViewItem("5", "마담 피카츄", R.drawable.pikachu_madam));
        adapter.addItem(new Ex11ListViewItem("6", "마스크드 피카츄", R.drawable.pikachu_masked));

        //리스트뷰에 Adapter 설정
        listview.setAdapter(adapter);
    }


    /* 리스트뷰 어댑터 */
    public class ListViewAdapter extends BaseAdapter {
        ArrayList<Ex11ListViewItem> items = new ArrayList<Ex11ListViewItem>();

        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(Ex11ListViewItem item) {
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
            final Ex11ListViewItem pikachuItem = items.get(position);

            if(convertView == null) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.activity_ex11_list_view_item, viewGroup, false);

            } else {
                View view = new View(context);
                view = (View) convertView;
            }

            TextView tv_num = (TextView) convertView.findViewById(R.id.tvNum);
            TextView tv_name = (TextView) convertView.findViewById(R.id.tvName);
            ImageView iv_icon = (ImageView) convertView.findViewById(R.id.ivImg);

            tv_num.setText(pikachuItem.getNum());
            tv_name.setText(pikachuItem.getName());
            iv_icon.setImageResource(pikachuItem.getResId());
            Log.d(TAG, "getView() - [ "+position+" ] "+pikachuItem.getName());

            //각 아이템 선택 event
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, pikachuItem.getNum()+" 번 - "+pikachuItem.getName()+" 입니당! ", Toast.LENGTH_SHORT).show();
                }
            });

            return convertView;  //뷰 객체 반환
        }
    }

}