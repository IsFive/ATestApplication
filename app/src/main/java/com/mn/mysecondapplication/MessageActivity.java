package com.mn.mysecondapplication;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class MessageActivity extends Activity{
    public String[] name = { "第二次跳转", "吴二", "李三", "黄四", "赵五" };
    private String message[]={"你好,白浅","你好,夜华","你好,东华","你好,凤九","你好,墨渊"};
    private String time[]={"23:34","21:59","20:30","20:15","18:30"};
    public int[] image = { R.drawable.home_occupation,
            R.drawable.home_speciality, R.drawable.home_together,
            R.drawable.home_welfare, R.drawable.mb };

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.message_main);

        ListView listView =(ListView) findViewById(R.id.listView);

        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();

        for (int i = 0; i < name.length; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("name", name[i]);
            map.put("image", image[i]);
            map.put("message", message[i]);
            map.put("time", time[i]);
            list.add(map);
        }

        SimpleAdapter sa = new SimpleAdapter(this, list,
                R.layout.item2, new String[] { "name","image","message","time" },
                new int[] { R.id.name, R.id.image,R.id.message,R.id.time });
        listView.setAdapter(sa);

        TextView myfriends2 = (TextView) findViewById(R.id.myFriend2);
        myfriends2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MessageActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}