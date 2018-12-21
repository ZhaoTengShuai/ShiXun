package com.example.zhaotengshuai20181221.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class MyFragmentAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> aList;
    private Context mContext;

    public MyFragmentAdapter(FragmentManager fm, ArrayList<Fragment> aList, Context mContext) {
        super(fm);
        this.aList = aList;
        this.mContext = mContext;
    }

    @Override
    public Fragment getItem(int i) {
        return aList.get(i);
    }

    @Override
    public int getCount() {
        return aList.size();
    }
}
