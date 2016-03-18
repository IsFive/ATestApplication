package com.mn.mysecondapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    public String[] name = { "庄一", "吴二", "李三", "黄四", "赵五" };
    public String[] sex = { "女", "男", "男", "女", "男" };
    public String[] major = { "软件", "软件", "空间", "会计", "医生" };
    public int[] image = { R.drawable.home_occupation,
            R.drawable.home_speciality, R.drawable.home_together,
            R.drawable.home_welfare, R.drawable.mb };
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<ItemBean> mList = new ArrayList<ItemBean>();
        for (int i = 0; i < name.length; i++) {
            mList.add(new ItemBean(image[i], name[i], sex[i], major[i]));
        }
        listView = (ListView) findViewById(R.id.lv_main);
        listView.setAdapter(new MyAdapter(this, mList));

        TextView message = (TextView) findViewById(R.id.message1);
        message.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, MessageActivity.class);
                startActivity(intent);
            }
        });
    }
}
