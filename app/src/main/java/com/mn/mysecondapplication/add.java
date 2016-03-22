package com.mn.mysecondapplication;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class add extends Activity{
    private ItemBean stu;
    private ImageView iv_image;
    private EditText tv_name;
    private RadioGroup rg_sex;
    private RadioButton but1;
    private RadioButton but2;
    private String sex;
    private EditText tv_major;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add);
        iv_image= (ImageView) findViewById(R.id.image);
        tv_name= (EditText) findViewById(R.id.add_name_edit);
        tv_major= (EditText) findViewById(R.id.add_major_edit);
        rg_sex= (RadioGroup) findViewById(R.id.add_radiogroup);
        but1= (RadioButton) findViewById(R.id.add_radionbutton1);
        but2= (RadioButton) findViewById(R.id.add_radionbutton2);
        Button add= (Button) findViewById(R.id.add);
        rg_sex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==R.id.add_radionbutton1)
                    sex=but1.getText().toString();
                else
                    sex=but2.getText().toString();
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //操作数据库
                stu=new ItemBean(R.drawable.home_welfare,tv_name.getText().toString(),sex,tv_major.getText().toString());
                ContentValues cv=new ContentValues();
                cv.put("image",R.drawable.home_welfare);
                cv.put("name",tv_name.getText().toString());
                cv.put("sex",sex);
                cv.put("major",tv_major.getText().toString());
                SqliteDao dao=new SqliteDao("write",add.this);
                dao.insert("friend",cv);
                Intent intent = new Intent();
                intent.setClass(add.this, MainActivity.class);
                startActivity(intent);
            }
        });
        Button fanhui= (Button) findViewById(R.id.fanhui);
        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(add.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
