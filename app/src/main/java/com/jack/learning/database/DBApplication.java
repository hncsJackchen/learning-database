package com.jack.learning.database;

import android.app.Application;

import com.jack.learning.database.database.android.SQLiteDBHelper;
import com.jack.learning.database.database.greendao.DBInterface;

/**
 * author: jack
 * date: 2020/1/11 16:19
 * desc: 应用程序入口
 */
public class DBApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    /**
     * 初始化
     */
    private void init() {
        //初始化数据库
        SQLiteDBHelper.init(this);
        DBInterface.getInstance().init(this, "");
    }
}
