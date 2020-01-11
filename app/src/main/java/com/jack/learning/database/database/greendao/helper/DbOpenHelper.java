package com.jack.learning.database.database.greendao.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.jack.learning.database.database.greendao.code.DaoMaster;
import com.jack.learning.database.database.greendao.upgrade.DbVersion;
import com.jack.learning.database.database.greendao.upgrade.IUpgrade;
import com.jack.learning.database.util.LogUtils;

import java.util.Set;
import java.util.SortedMap;


/**
 * author : jack
 * date : 2018/10/5 14:25
 * desc : 管理数据库的创建和升级
 */
public class DbOpenHelper extends DaoMaster.OpenHelper {
    private static final String TAG = "DbOpenHelper";

    public DbOpenHelper(Context context, String name) {
        super(context, name);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        LogUtils.d(TAG, "onCreate");
        super.onCreate(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        LogUtils.d(TAG, "Upgrade from " + oldVersion + " to " + newVersion);
        SortedMap<Integer, IUpgrade> migrations = DbVersion.ALL_MIGRATIONS.subMap(oldVersion + 1, newVersion + 1);
        executeUpgrade(sqLiteDatabase, migrations.keySet());
    }

    private void executeUpgrade(final SQLiteDatabase paramSQLiteDatabase,
                                final Set<Integer> migrationVersions) {
        for (final Integer version : migrationVersions) {
            LogUtils.d(TAG, "upgrade database,version is:" + version);
            DbVersion.ALL_MIGRATIONS.get(version).upgrade(paramSQLiteDatabase);
        }
    }
}