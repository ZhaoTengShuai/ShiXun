package com.example.zhaotengshuai20181221.callback;

public interface MyCallBack<T> {

    void setData(T user);
    void setError(T error);
}
