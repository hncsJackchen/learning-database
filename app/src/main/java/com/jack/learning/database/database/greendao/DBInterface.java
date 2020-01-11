package com.jack.learning.database.database.greendao;

import android.content.Context;
import android.text.TextUtils;

import com.jack.learning.database.database.greendao.code.DaoMaster;
import com.jack.learning.database.database.greendao.code.DaoSession;
import com.jack.learning.database.database.greendao.helper.DbOpenHelper;
import com.jack.learning.database.database.greendao.manager.PeopleTableManager;
import com.jack.learning.database.util.LogUtils;

/**
 * author: jack
 * date: 2018/10/5 14:32
 * desc: 数据库访问接口
 */
public class DBInterface {
    private static final String TAG = "DBInterface";
    private static final String DB_NAME = "greendao.db";
    private static DBInterface instance;
    private DaoSession mDaoSession;

    //数据库表管理者
    private PeopleTableManager peopleTableManager;

    public static DBInterface getInstance() {
        if (instance == null) {
            synchronized (DBInterface.class) {
                if (instance == null) {
                    instance = new DBInterface();
                }
            }
        }
        return instance;
    }

    private DBInterface() {
    }

    /**
     * 初始化数据库
     *
     * @param context 上下文
     * @param name    数据库名
     */
    public void init(Context context, String name) {
        String dbName = TextUtils.isEmpty(name) ? DB_NAME : name;
        LogUtils.d(TAG, "init database(name=" + dbName + "),context=" + context.getClass());
        DbOpenHelper helper = new DbOpenHelper(context, dbName);
        mDaoSession = new DaoMaster(helper.getWritableDatabase()).newSession();
        peopleTableManager = new PeopleTableManager(mDaoSession.getPeopleTableDao());
    }

    public DaoSession getDaoSession() {
        return mDaoSession;
    }

    public PeopleTableManager getContactTableManager() {
        return peopleTableManager;
    }


}
