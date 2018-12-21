package com.example.zhaotengshuai20181221.model;

import android.os.AsyncTask;

import com.example.zhaotengshuai20181221.bean.MyData;
import com.example.zhaotengshuai20181221.bean.MyUser;
import com.example.zhaotengshuai20181221.callback.MyCallBack;
import com.example.zhaotengshuai20181221.utils.OkHttpUtils;
import com.google.gson.Gson;

import java.io.IOException;

public class ModelImpl implements Model{

    private MyCallBack callBack;

    @Override
    public void getData(String url, MyCallBack callBack) {

        this.callBack=callBack;

        new MyTask<>().execute(url);
    }


    class MyTask<T> extends AsyncTask<String,Void,T> {

        @Override
        protected T doInBackground(String... strings) {

            try {
                String jsonStr = OkHttpUtils.getInstance().get(strings[0]);
                Gson gson=new Gson();
                MyData myData = gson.fromJson(jsonStr, MyData.class);
                return (T) myData;

            } catch (IOException e) {
                e.printStackTrace();
            }


            return null;
        }

        @Override
        protected void onPostExecute(T t) {
            super.onPostExecute(t);
            callBack.setData(t);
        }
    }

}
