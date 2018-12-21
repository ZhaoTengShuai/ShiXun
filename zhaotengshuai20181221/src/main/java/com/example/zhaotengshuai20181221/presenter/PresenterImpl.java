package com.example.zhaotengshuai20181221.presenter;

import com.example.zhaotengshuai20181221.callback.MyCallBack;
import com.example.zhaotengshuai20181221.model.ModelImpl;
import com.example.zhaotengshuai20181221.view.IView;

public class PresenterImpl implements Presenter {

    private ModelImpl model;
    private IView iView;

    public PresenterImpl(IView iView) {
        this.iView = iView;
        model = new ModelImpl();
    }


    @Override
    public void startRequse(final String url) {
        model.getData(url, new MyCallBack() {
            @Override
            public void setData(Object user) {
                iView.success(user);
            }

            @Override
            public void setError(Object error) {
                iView.error(error);
            }
        });
    }
}
