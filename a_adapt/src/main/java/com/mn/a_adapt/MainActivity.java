package com.mn.a_adapt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private int[] img={R.drawable.home_speciality,R.drawable.home_occupation,R.drawable.home_welfare,R.drawable.home_together,R.drawable.mb};
    private String[] name={"笑话","撒旦法","速度","恶风","才的"};
    private String[] sex={"男","女","不男不女","人妖","太监"};
    private String[] major={"dfddsaf","gjghf","xcvv","sfd","hgdsfdgz"};
     @Override
    protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);
         ListView listView;
         listView= (ListView) findViewById(R.id.listView);
         List<items> mlist=new ArrayList<>();
         for(int i=0;i<5;i++)
         {
             mlist.add(new items(img[i],name[i],sex[i],major[i]));
         }
         listView.setAdapter(new MyAdapt(this,mlist));
     }
}
