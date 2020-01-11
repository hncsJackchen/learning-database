package com.jack.learning.database.database.greendao.upgrade;

import android.database.sqlite.SQLiteDatabase;

import com.jack.learning.database.database.greendao.code.PeopleTableDao;
import com.jack.learning.database.database.greendao.helper.MigrationHelper;
import com.jack.learning.database.util.LogUtils;


/**
 * author : jack
 * date : 2019/12/23 22:27
 * desc : 数据库升级内容
 */
public class UpgradeV2 implements IUpgrade {
    private static final String TAG = "UpgradeV2";

    @Override
    public void upgrade(SQLiteDatabase db) {
        LogUtils.d(TAG, "upgrade");
        //升级内容：
        //[version:1-2]
        //1.表PeopleTableDao增加字段xxx
        MigrationHelper.migrate(db, PeopleTableDao.class);

    }
}
