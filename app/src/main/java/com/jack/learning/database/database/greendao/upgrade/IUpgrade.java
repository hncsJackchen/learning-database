package com.jack.learning.database.database.greendao.upgrade;

import android.database.sqlite.SQLiteDatabase;

/**
 * author : jack
 * date : 2018/10/5 15:27
 * desc :数据库升级内容，包括以下2 种情况：
 * 1.增加新表;[LastPlayInfoDao.createTable(new StandardDatabase(db), false);]
 * 2.给已存在的表增加字段;[ MigrationHelper.upgrade(db, LastPlayInfoDao.class);]
 */
public interface IUpgrade {
    void upgrade(SQLiteDatabase db);
}
