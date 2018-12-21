package com.example.zhaotengshuai20181221;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.zhaotengshuai20181221.adapter.MyFragmentAdapter;
import com.example.zhaotengshuai20181221.fragment.AFragment;
import com.example.zhaotengshuai20181221.fragment.BFragment;
import com.example.zhaotengshuai20181221.fragment.CFragment;
import com.example.zhaotengshuai20181221.fragment.DFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager Vp;
    private ArrayList<Fragment> aList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        MyFragmentAdapter myFragmentAdapter=new MyFragmentAdapter(getSupportFragmentManager(),aList,this);
        Vp.setAdapter(myFragmentAdapter);

    }

    private void initData() {

        aList = new ArrayList<>();
        aList.add(new AFragment());
        aList.add(new BFragment());
        aList.add(new CFragment());
        aList.add(new DFragment());

    }

    private void initView() {
        Vp = (ViewPager) findViewById(R.id.Vp);
    }




}
