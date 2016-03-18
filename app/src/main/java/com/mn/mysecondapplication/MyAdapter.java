package com.mn.mysecondapplication;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter{
    private Context context;
    List<ItemBean> mList;
    private LayoutInflater mInflater;
    public MyAdapter(Context context,List<ItemBean> mList) {
        this.context=context;
        this.mList = mList;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View converView, ViewGroup parent) {
        // TODO Auto-generated method stub
        final VH vh;
        if(converView == null)
        {
            converView = mInflater.inflate(R.layout.item, null);
            vh = new VH();
            vh.image=(ImageView) converView.findViewById(R.id.image);
            vh.name=(TextView) converView.findViewById(R.id.name);
            vh.sex=(TextView) converView.findViewById(R.id.sex);
            vh.major=(TextView) converView.findViewById(R.id.major);
            converView.setTag(vh);
        }
        else
        {
            vh=(VH) converView.getTag();
        }
        final ItemBean item =mList.get(position);
        vh.image.setImageResource(item.image);
        vh.name.setText(item.name);
        vh.sex.setText(item.sex);
        vh.major.setText(item.major);
        vh.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                Bundle bundle=new Bundle();
                bundle.putSerializable("item",item);
                intent.setClass(context,DetailActivity.class);
                intent.putExtra("bundle", bundle);
                context.startActivity(intent);
            }
        });
        return converView;

    }
    class VH
    {
        private ImageView image;
        private TextView name;
        private TextView sex;
        private TextView major;
    }
}

