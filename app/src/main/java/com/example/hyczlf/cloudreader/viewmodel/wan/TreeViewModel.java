package com.example.hyczlf.cloudreader.viewmodel.wan;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.hyczlf.cloudreader.bean.wanandroid.NaviJsonBean;
import com.example.hyczlf.cloudreader.bean.wanandroid.TreeBean;
import com.example.hyczlf.cloudreader.http.HttpClient;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author hyczlf
 * @data 2018/12/3
 * @Description wanandroid知识体系的ViewModel
 */

public class TreeViewModel extends ViewModel {


    public MutableLiveData<TreeBean> getTree() {
        final MutableLiveData<TreeBean> data = new MutableLiveData<>();
        HttpClient.Builder.getWanAndroidServer().getTree()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<TreeBean>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        data.setValue(null);
                    }

                    @Override
                    public void onNext(TreeBean treeBean) {
                        data.setValue(treeBean);
                    }
                });
        return data;
    }
}
