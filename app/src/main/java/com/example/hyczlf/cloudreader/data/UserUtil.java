package com.example.hyczlf.cloudreader.data;

import android.content.Context;

import com.example.hyczlf.cloudreader.app.Constants;
import com.example.hyczlf.cloudreader.data.room.Injection;
import com.example.hyczlf.cloudreader.data.room.User;
import com.example.hyczlf.cloudreader.data.room.UserDataCallback;
import com.example.hyczlf.cloudreader.ui.menu.LoginActivity;
import com.example.hyczlf.cloudreader.utils.SPUtils;
import com.example.hyczlf.cloudreader.utils.ToastUtil;

/**
 * @author hyczlf
 * @data 2018/5/7
 * @Description 处理用户登录问题
 */

public class UserUtil {

    /**
     * 初始化登录状态
     */
    public static void getLoginStatus() {
        Injection.get().getSingleBean(new UserDataCallback() {
            @Override
            public void onDataNotAvailable() {
                SPUtils.putBoolean(Constants.IS_LOGIN, false);
            }

            @Override
            public void getData(User bean) {
                SPUtils.putBoolean(Constants.IS_LOGIN, true);
            }
        });
    }

    public static void handleLoginSuccess() {
        SPUtils.putBoolean(Constants.IS_LOGIN, true);
    }

    public static void handleLoginFailure() {
        SPUtils.putBoolean(Constants.IS_LOGIN, false);
        SPUtils.putString("cookie", "");
        SPUtils.remove("cookie");
    }

    /**
     * 是否登录，没有进入登录页面
     */
    public static boolean isLogin(Context context) {
        boolean isLogin = SPUtils.getBoolean(Constants.IS_LOGIN, false);
        if (!isLogin) {
            ToastUtil.showToastLong("请先登录~");
            LoginActivity.start(context);
            return false;
        } else {
            return true;
        }
    }
}
