package com.example.zhaotengshuai20181221;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.zhaotengshuai20181221.bean.MyStudent;

import java.util.ArrayList;
import java.util.Random;

public class RecyListAdapter extends RecyclerView.Adapter<RecyListAdapter.ViewHolder> implements View.OnClickListener {
    private ArrayList<MyStudent.DataBean> hList=new ArrayList<>();
    private Context mContext;

    public RecyListAdapter(ArrayList<MyStudent.DataBean> hList, Context mContext) {
        this.hList = hList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public RecyListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.recy_list_item,viewGroup,false);
        ViewHolder holder=new ViewHolder(view);
        view.setOnClickListener(this);
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull RecyListAdapter.ViewHolder viewHolder, int i) {
        MyStudent.DataBean myStudent= hList.get(i);
        ViewGroup.LayoutParams params=viewHolder.itemView.getLayoutParams();
        Random random=new Random();
        int height  =random.nextInt(300)+300;
        params.height=height;
        viewHolder.itemView.setLayoutParams(params);

        viewHolder.Recy_List_Text.setText(hList.get(i).getAuthor_name());
        Glide.with(mContext).load(hList.get(i).getThumbnail_pic_s()).into(viewHolder.Recy_List_Image);

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    public void onClick(View v) {

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView Recy_List_Image;
        private TextView Recy_List_Text;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            Recy_List_Image = itemView.findViewById(R.id.Recy_List_Image);
            Recy_List_Text = itemView.findViewById(R.id.Recy_List_Text);
        }
    }
}
