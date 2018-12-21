package com.example.zhaotengshuai20181221.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.zhaotengshuai20181221.R;
import com.example.zhaotengshuai20181221.bean.MyData;

import java.util.ArrayList;

public class MyRecyAdapter extends RecyclerView.Adapter<MyRecyAdapter.ViewHolder> implements View.OnClickListener {

    private ArrayList<MyData.DataBean> mList=new ArrayList<>();
    private Context mContext;

    public MyRecyAdapter(ArrayList<MyData.DataBean> mList, Context mContext) {
        this.mList = mList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public MyRecyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       View view= LayoutInflater.from(mContext).inflate(R.layout.recy_item,viewGroup,false);
        ViewHolder holder=new ViewHolder(view);
        view.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecyAdapter.ViewHolder viewHolder, int i) {

        viewHolder.recy_text.setText(mList.get(i).getName()+"");
        Glide.with(mContext).load(mList.get(i).getIcon()).into(viewHolder.recy_image);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public void onClick(View v) {

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private  ImageView recy_image;
        private  TextView recy_text;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            recy_image = itemView.findViewById(R.id.Recy_Image);
            recy_text = itemView.findViewById(R.id.Recy_Text);

        }
    }
}
