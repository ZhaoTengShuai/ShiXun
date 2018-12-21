package com.example.zhaotengshuai20181221.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.zhaotengshuai20181221.R;
import com.example.zhaotengshuai20181221.bean.MyUser;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {

    private ArrayList<MyUser.DataBean> mList;
    private Context mContext;

    public MyAdapter(ArrayList<MyUser.DataBean> mList, Context mContext) {
        this.mList = mList;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null){
             holder=new ViewHolder();
            convertView=View.inflate(mContext,R.layout.list_item,null);
            holder.Image=convertView.findViewById(R.id.Image);
            convertView.setTag(holder);
        }else{
           holder= (ViewHolder) convertView.getTag();
        }
        Glide.with(mContext).load(mList.get(position).getUrl()).into(holder.Image);


        return convertView;
    }

    class ViewHolder{

        private ImageView Image;
    }

}
