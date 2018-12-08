package com.example.hyczlf.cloudreader.viewmodel.wan;

import com.example.hyczlf.cloudreader.base.BaseListViewModel;
import com.example.hyczlf.cloudreader.bean.CollectUrlBean;
import com.example.hyczlf.cloudreader.http.HttpClient;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author hyczlf
 * @data 2018/5/9
 * @Description 文章列表ViewModel
 */

public class CollectLinkModel extends BaseListViewModel {

    private WanNavigator.CollectUrlNavigator navigator;

    public CollectLinkModel(WanNavigator.CollectUrlNavigator navigator) {
        this.navigator = navigator;
    }

    public void getCollectUrlList() {
        Subscription subscribe = HttpClient.Builder.getWanAndroidServer().getCollectUrlList()
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CollectUrlBean>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        navigator.loadFailure();
                    }

                    @Override
                    public void onNext(CollectUrlBean bean) {
                        navigator.showLoadSuccessView();
                        if (bean == null || bean.getData() == null || bean.getData().size() <= 0) {
                            navigator.loadFailure();
                            return;
                        }
                        navigator.showAdapterView(bean);
                    }
                });
        navigator.addRxSubscription(subscribe);
    }

    public void onDestroy() {
        navigator = null;
    }
}
