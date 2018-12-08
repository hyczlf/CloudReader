package com.example.hyczlf.cloudreader.viewmodel.wan;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableField;
import android.text.TextUtils;

import com.example.hyczlf.cloudreader.bean.wanandroid.LoginBean;
import com.example.hyczlf.cloudreader.bean.wanandroid.NaviJsonBean;
import com.example.hyczlf.cloudreader.data.UserUtil;
import com.example.hyczlf.cloudreader.data.room.Injection;
import com.example.hyczlf.cloudreader.http.HttpClient;
import com.example.hyczlf.cloudreader.utils.ToastUtil;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author hyczlf
 * @data 2018/12/3
 * @Description wanandroid导航数据的ViewModel
 */

public class NaviViewModel extends ViewModel {

    public MutableLiveData<NaviJsonBean> getNaviJson() {
        final MutableLiveData<NaviJsonBean> data = new MutableLiveData<>();
        HttpClient.Builder.getWanAndroidServer().getNaviJson()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<NaviJsonBean>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        data.setValue(null);
                    }

                    @Override
                    public void onNext(NaviJsonBean naviJsonBean) {
                        if (naviJsonBean != null
                                && naviJsonBean.getData() != null
                                && naviJsonBean.getData().size() > 0) {

                            data.setValue(naviJsonBean);
                        } else {
                            data.setValue(null);
                        }
                    }
                });
        return data;
    }
}
