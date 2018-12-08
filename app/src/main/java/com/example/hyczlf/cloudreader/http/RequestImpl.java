package com.example.hyczlf.cloudreader.http;

import rx.Subscription;

/**
 * Created by hyczlf on 2017/1/17.
 * 用于数据请求的回调
 */

public interface RequestImpl {
    void loadSuccess(Object object);

    void loadFailed();

    void addSubscription(Subscription subscription);
}
