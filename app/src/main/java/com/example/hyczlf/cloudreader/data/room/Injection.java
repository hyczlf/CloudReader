package com.example.hyczlf.cloudreader.data.room;

import com.example.hyczlf.cloudreader.utils.AppExecutors;

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
