package com.example.jingbin.cloudreader.data.room;

import com.example.jingbin.cloudreader.utils.AppExecutors;

/**
 * @author hyczlf
 * @data 2018/4/19
 * @Description
 */

public class Injection {

    public static UserDataBaseSource get() {
        UserDataBase database = UserDataBase.getDatabase();
        return UserDataBaseSource.getInstance(new AppExecutors(), database.waitDao());
    }

}
