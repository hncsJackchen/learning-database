package com.jack.learning.database.database.android;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.jack.learning.database.util.LogUtils;

/**
 * Author： Jackchen
 * Time： 2016/11/29
 * Description:数据库帮助类
 */
public class SQLiteDBHelper extends SQLiteOpenHelper {
    private static final String TAG = "AndroidDBHelper";

    //数据库名字
    private static final String DB_NAME = "sqlite.db";
    //数据库版本号
    private static final int DB_VERSION = 1;

    //是否初始化
    private static boolean mIsInitialized = false;
    private static SQLiteDBHelper mDBHelper;
    private static SQLiteDatabase writableDatabase;

    public SQLiteDBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        LogUtils.i(TAG, "onCreate() " + db.getVersion());
        String createTable =
            "create table people(pid integer primary key autoincrement,name TEXT,age INTEGER,sex INTEGER,city TEXT,height REAL)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        LogUtils.i(TAG, "onUpgrade() oldVersion=" + oldVersion + ",newVersion=" + newVersion);
        String sql = "alter table people add weight REAL";
        db.execSQL(sql);
    }

    /**
     * 初始化，一般在Application的onCreate()中调用
     *
     * @param context
     */
    public static void init(Context context) {
        if (mIsInitialized) {
            LogUtils.e(TAG, "already initialized.");
            return;
        }

        mDBHelper = new SQLiteDBHelper(context);
        writableDatabase = mDBHelper.getWritableDatabase();

        mIsInitialized = true;
        LogUtils.i(TAG, "initialized successfully.");
    }

    /**
     * 在需要使用数据库的地方调用
     *
     * @return db or null if the db not initialized
     */
    public static SQLiteDatabase getDB() {
        if (!mIsInitialized) {
            LogUtils.e(TAG, "you must call init()");
            return null;
        }
        
        return writableDatabase;
    }
}
