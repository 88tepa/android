package com.mkj.android_study_220829_1;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Ex12ListView2 extends AppCompatActivity {
    private String TAG = "음악 리스트뷰 예제";
    private ListView listview = null;
    private ListViewAdapter adapter = null;

    Animation ani1;
    MediaPlayer player1, player2, player3, player4, player5;
    ImageButton btnPp, btnBack;
    ImageView albumImg;

    LinearLayout frame1, frame2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex12_list_view2);

        frame1 = (LinearLayout)findViewById(R.id.frame1);
        frame2 = (LinearLayout)findViewById(R.id.frame2);

        player1 = MediaPlayer.create(Ex12ListView2.this, R.raw.hahyunwoo_jilpoong);
        player2 = MediaPlayer.create(Ex12ListView2.this, R.raw.babayetu);
        player3 = MediaPlayer.create(Ex12ListView2.this, R.raw.electric_romeo);
        player4 = MediaPlayer.create(Ex12ListView2.this, R.raw.howls_moving_castle);
        player5 = MediaPlayer.create(Ex12ListView2.this, R.raw.immortals);

        btnPp = findViewById(R.id.btnPp);
        btnBack = findViewById(R.id.btnBack);
        findViewById(R.id.btnPp).setOnClickListener(mClick);
        findViewById(R.id.btnBack).setOnClickListener(mClick);
        albumImg = (ImageView)findViewById(R.id.albumImg);
        ani1 = AnimationUtils.loadAnimation(Ex12ListView2.this, R.anim.touch);


        listview = (ListView) findViewById(R.id.listView);
        adapter = new ListViewAdapter();

        //Adapter 안에 아이템의 정보 담기
        adapter.addItem(new Ex12ListView2Item("1", "hahyunwoo_jilpoong", R.drawable.hahyunwoo_jilpoong));
        adapter.addItem(new Ex12ListView2Item("2", "babayetu", R.drawable.babayetu));
        adapter.addItem(new Ex12ListView2Item("3", "electric_romeo", R.drawable.eletric_romeo));
        adapter.addItem(new Ex12ListView2Item("4", "howls_moving_castle", R.drawable.howls_moving_castle));
        adapter.addItem(new Ex12ListView2Item("5", "immortals", R.drawable.immortals));

        //리스트뷰에 Adapter 설정
        listview.setAdapter(adapter);
    }
    /* 리스트뷰 어댑터 */
    public class ListViewAdapter extends BaseAdapter {
        ArrayList<Ex12ListView2Item> items = new ArrayList<Ex12ListView2Item>();

        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(Ex12ListView2Item item) {
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
            final Ex12ListView2Item musicItem = items.get(position);

            if(convertView == null) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.activity_ex12_list_view2_item, viewGroup, false);

            } else {
                View view = new View(context);
                view = (View) convertView;
            }

            TextView tv_num = (TextView) convertView.findViewById(R.id.tvNum);
            TextView tv_name = (TextView) convertView.findViewById(R.id.tvName);
            ImageView iv_icon = (ImageView) convertView.findViewById(R.id.ivImg);

            tv_num.setText(musicItem.getNum());
            tv_name.setText(musicItem.getName());
            iv_icon.setImageResource(musicItem.getResId());
            Log.d(TAG, "getView() - [ "+position+" ] "+musicItem.getName());

            //각 아이템 선택 event
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    frame1.setVisibility(View.INVISIBLE);
                    frame2.setVisibility(View.VISIBLE);
                    Toast.makeText(context, musicItem.getNum()+" 번 - "+musicItem.getName()+" 입니당! ", Toast.LENGTH_SHORT).show();

                    if(R.id.tvNum == 1) {
                        albumImg.setImageResource(R.drawable.hahyunwoo_jilpoong);
                    }
                }
            });
            return convertView;  //뷰 객체 반환
        }
    }
    View.OnClickListener mClick = new View.OnClickListener()
    {
        public void onClick(View v)
        {
            switch(v.getId())
            {
                case R.id.btnBack:
                    frame1.setVisibility(View.VISIBLE);
                    frame2.setVisibility(View.INVISIBLE);
                    break;
                case R.id.btnPp:
                    btnPp.startAnimation(ani1);
                    player1.start();
                    break;
            }
        }
    };
}