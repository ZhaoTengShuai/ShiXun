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
import com.example.zhaotengshuai20181221.bean.MyStudent;

import java.util.ArrayList;
import java.util.Random;

public class AdapterRecy extends RecyclerView.Adapter<AdapterRecy.ViewHolder> implements View.OnClickListener {
    private ArrayList<MyStudent.DataBean> nList=new ArrayList<>();
    private Context mContext;

    public AdapterRecy(ArrayList<MyStudent.DataBean> nList, Context mContext) {
        this.nList = nList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public AdapterRecy.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.recy_list_item,viewGroup,false);
        ViewHolder holder=new ViewHolder(view);
        view.setOnClickListener(this);
        return holder;


    }

    @Override
    public void onBindViewHolder(@NonNull AdapterRecy.ViewHolder viewHolder, int i) {

//       MyStudent.DataBean myStudent= nList.get(i);
//        ViewGroup.LayoutParams params=viewHolder.itemView.getLayoutParams();
//        Random random=new Random();
//      int height  =random.nextInt(300)+300;
//      params.height=height;
//      viewHolder.itemView.setLayoutParams(params);

        viewHolder.Recy_List_Text.setText(nList.get(i).getAuthor_name());

        Glide.with(mContext).load(nList.get(i).getThumbnail_pic_s()).into(viewHolder.Recy_List_Image);

        viewHolder.itemView.setTag(i);


      }

    @Override
    public int getItemCount() {
        return nList.size();
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

    public interface ItemClick{
        void setOnItem(View v,int position);
    }

    private ItemClick itemClick;

    public void setOnItemClick(ItemClick itemClick){
        this.itemClick=itemClick;
    }

    @Override
    public void onClick(View v) {

        if(itemClick!=null){
            itemClick.setOnItem(v, (Integer) v.getTag());

        }
    }

}
