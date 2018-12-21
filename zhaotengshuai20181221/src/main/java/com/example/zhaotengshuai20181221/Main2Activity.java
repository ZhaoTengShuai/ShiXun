package com.example.zhaotengshuai20181221;

import android.Manifest;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.PermissionChecker;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zhaotengshuai20181221.adapter.AdapterRecy;
import com.example.zhaotengshuai20181221.adapter.MyRecyAdapter;
import com.example.zhaotengshuai20181221.bean.MyData;
import com.example.zhaotengshuai20181221.bean.MyStudent;
import com.example.zhaotengshuai20181221.presenter.PresenterImpl;
import com.example.zhaotengshuai20181221.utils.OkHttpUtils;
import com.example.zhaotengshuai20181221.view.IView;
import com.google.gson.Gson;
import com.yzq.zxinglibrary.android.CaptureActivity;
import com.yzq.zxinglibrary.common.Constant;

import java.io.IOException;
import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity implements IView, View.OnClickListener {

    private TextView Sao_Yi_Sao;
    private EditText Et_Name;
    private TextView QieHuan;
    private RecyclerView Recy_Biao;
    private RecyclerView Recy_List;
    private ArrayList<MyData.DataBean> mList = new ArrayList<>();
    private String mUrl = "http://www.zhaoapi.cn/product/getCatagory";
    private PresenterImpl presenter;
    private MyRecyAdapter recyAdapter;
    private String mUrll = "http://www.xieast.com/api/news/news.php?page=";
    private ArrayList<MyStudent.DataBean> nList = new ArrayList<>();
    private AdapterRecy adapterRecy;
    private RecyclerView Recy_Group_List;
    private ArrayList<MyStudent.DataBean>hList=new ArrayList<>();
    private RecyListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
        presenter = new PresenterImpl(this);
        recyAdapter = new MyRecyAdapter(mList, this);
        Recy_Biao.setAdapter(recyAdapter);
        presenter.startRequse(mUrl);

        adapterRecy = new AdapterRecy(nList, this);
        Recy_List.setAdapter(adapterRecy);
        new MyTask().execute(mUrll);
        adapterRecy.notifyDataSetChanged();

        listAdapter = new RecyListAdapter(hList,this);
        Recy_Group_List.setAdapter(listAdapter);
        new MyTask().execute(mUrll);
        listAdapter.notifyDataSetChanged();

        adapterRecy.setOnItemClick(new AdapterRecy.ItemClick() {
            @Override
            public void setOnItem(View v, int position) {
                Toast.makeText(Main2Activity.this,nList.get(position).getUrl()+"",Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void initView() {
        Sao_Yi_Sao = (TextView) findViewById(R.id.Sao_Yi_Sao);
        Et_Name = (EditText) findViewById(R.id.Et_Name);
        QieHuan = (TextView) findViewById(R.id.QieHuan);
        Recy_Biao = (RecyclerView) findViewById(R.id.Recy_Biao);
        Recy_List = (RecyclerView) findViewById(R.id.Recy_List);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 5);
        Recy_Biao.setLayoutManager(layoutManager);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        Recy_List.setLayoutManager(linearLayoutManager);
        QieHuan.setOnClickListener(this);
        Sao_Yi_Sao.setOnClickListener(this);
        //StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        //Recy_Group_List.setLayoutManager(staggeredGridLayoutManager);
      // StaggeredGridLayoutManager staggeredGridLayoutManager=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
       //Recy_Group_List.setLayoutManager(staggeredGridLayoutManager);

        Recy_Group_List = (RecyclerView) findViewById(R.id.Recy_Group_List);

    }


    @Override
    public void success(Object data) {

        MyData myData = (MyData) data;
        mList.addAll(myData.getData());
        recyAdapter.notifyDataSetChanged();
    }

    @Override
    public void error(Object error) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.QieHuan:
                Toast.makeText(Main2Activity.this, "hahhahah", Toast.LENGTH_SHORT).show();
                Recy_List.setVisibility(View.GONE);
                // Recy_Group_List.setVisibility(View.VISIBLE);
                break;
            case R.id.Sao_Yi_Sao:


        }}







    class MyTask extends AsyncTask<String, Void, MyStudent> {
        @Override
        protected MyStudent doInBackground(String... strings) {
            String jsonStr = null;
            try {
                jsonStr = OkHttpUtils.getInstance().get(strings[0]);
                Gson gson = new Gson();
                MyStudent myStudent = gson.fromJson(jsonStr, MyStudent.class);
                return myStudent;
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(MyStudent myStudent) {
            super.onPostExecute(myStudent);
            nList.addAll(myStudent.getData());
            adapterRecy.notifyDataSetChanged();
        }
    }


}
