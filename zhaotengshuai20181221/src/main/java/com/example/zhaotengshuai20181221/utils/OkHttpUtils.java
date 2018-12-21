package com.example.zhaotengshuai20181221.utils;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpUtils {
    private OkHttpClient okHttpClient;
    private OkHttpUtils(){
        okHttpClient=new OkHttpClient();
    }

    public static OkHttpUtils getInstance(){

        return okHttpHolde.utils;

    }

    static class okHttpHolde{

        private static final OkHttpUtils utils=new OkHttpUtils();

    }

    public String get(String url) throws IOException {
        Request request=new Request.Builder().url(url).build() ;

        Response execute = okHttpClient.newCall(request).execute();

        return execute.body().string();
    }



}
