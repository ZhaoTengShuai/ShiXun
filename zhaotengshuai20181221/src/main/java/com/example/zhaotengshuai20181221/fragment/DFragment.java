package com.example.zhaotengshuai20181221.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.zhaotengshuai20181221.Main2Activity;
import com.example.zhaotengshuai20181221.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DFragment extends Fragment implements View.OnClickListener {


    private ImageView Frg_ImageD;
    private Button Tiao_Btn;

    public DFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_d, null);
        initView(view);



        return view;
    }

    private void initView(View view) {
        Frg_ImageD = (ImageView) view.findViewById(R.id.Frg_ImageD);
        Tiao_Btn = (Button) view.findViewById(R.id.Tiao_Btn);

        Tiao_Btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Tiao_Btn:

                Intent intent=new Intent(getContext(),Main2Activity.class);
                startActivity(intent);
                break;
        }
    }
}
