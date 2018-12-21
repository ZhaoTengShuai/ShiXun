package com.example.zhaotengshuai20181221.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zhaotengshuai20181221.R;
import com.example.zhaotengshuai20181221.adapter.MyAdapter;
import com.example.zhaotengshuai20181221.bean.MyUser;
import com.example.zhaotengshuai20181221.presenter.PresenterImpl;
import com.example.zhaotengshuai20181221.view.IView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class AFragment extends Fragment implements IView {


    //private ImageView Frg_ImageA;
    private ArrayList<MyUser.DataBean> mList = new ArrayList<>();
    private ViewPager Vp1;

    public AFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, null);

        initView(view);
        PresenterImpl presenter = new PresenterImpl(this);
        MyAdapter myAdapter = new MyAdapter(mList, getContext());



        return view;
    }

    private void initView(View view) {
        //Frg_ImageA = (ImageView) view.findViewById(R.id.Frg_ImageA);
        Vp1 = (ViewPager) view.findViewById(R.id.Vp1);

    }


    @Override
    public void success(Object data) {
        MyUser myUser = (MyUser) data;
        mList.addAll(myUser.getData());

    }

    @Override
    public void error(Object error) {

    }
}
