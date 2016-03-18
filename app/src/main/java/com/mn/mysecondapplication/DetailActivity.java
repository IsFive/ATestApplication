package com.mn.mysecondapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item3);

        Bundle bundle =  getIntent().getBundleExtra("bundle");

        ItemBean itemBean =  (ItemBean) bundle.get("item");

        String strname = itemBean.getName();
        String strsex = itemBean.getSex();
        String strmajor = itemBean.getMajor();
        int strimage = itemBean.getImage();

        TextView name = (TextView) findViewById(R.id.name);
        TextView sex = (TextView) findViewById(R.id.sex);
        TextView major = (TextView) findViewById(R.id.major);
        ImageView image = (ImageView) findViewById(R.id.image);


        name.setText("姓名："+strname);
        sex.setText("性别："+strsex);
        major.setText("专业："+strmajor);
        image.setImageResource(strimage);

        TextView myfriends2 = (TextView) findViewById(R.id.myfriends2);
        myfriends2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(DetailActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        TextView message = (TextView) findViewById(R.id.message);
        message.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(DetailActivity.this, MessageActivity.class);
                startActivity(intent);
            }
        });
    }
}
