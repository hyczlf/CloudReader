package com.example.hyczlf.cloudreader.viewmodel.movie;

import com.example.hyczlf.cloudreader.bean.HotMovieBean;

/**
 * @author hyczlf
 * @data 2017/12/26
 * @Description
 */

public interface OnMovieLoadListener {

    void onSuccess(HotMovieBean bean);

    void onFailure();
}
