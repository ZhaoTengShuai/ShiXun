package com.example.zhaotengshuai20181221.view;

public interface IView<T> {

    void success(T data);
    void error(T error);
}
