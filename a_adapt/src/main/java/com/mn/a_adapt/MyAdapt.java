package com.mn.a_adapt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by MN on 2016/3/13.
 */
public class MyAdapt extends BaseAdapter {
    List<items> mlist;
    private LayoutInflater mInflate;
    public MyAdapt(Context context, List<items> mlist) {
        this.mlist=mlist;
        mInflate=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mlist.size();
    }

    @Override
    public Object getItem(int position) {
        return mlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        VH vh;
        if(convertView==null)
        {
            vh=new VH();
            convertView=mInflate.inflate(R.layout.layout,null);
            vh.img= (ImageView) convertView.findViewById(R.id.imageView);
            vh.name= (TextView) convertView.findViewById(R.id.name);
            vh.sex= (TextView) convertView.findViewById(R.id.sex);
            vh.major= (TextView) convertView.findViewById(R.id.major);
            convertView.setTag(vh);
        }else
        {
            vh=(VH)convertView.getTag();
        }
        items item=mlist.get(position);
        vh.img.setImageResource(item.img);
        vh.name.setText(item.name);
        vh.sex.setText(item.sex);
        vh.major.setText(item.major);
        return convertView;
    }
    class VH{
        private ImageView img;
        private TextView name;
        private TextView sex;
        private TextView major;
    }
}
