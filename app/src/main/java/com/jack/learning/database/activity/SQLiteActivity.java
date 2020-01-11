package com.jack.learning.database.activity;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jack.learning.database.R;
import com.jack.learning.database.database.android.SQLiteDBHelper;
import com.jack.learning.database.util.LogUtils;

public class SQLiteActivity extends Activity implements View.OnClickListener {
    private static final String TAG = "AndroidActivity";
    private Button mBtnInsert, mBtnDelete, mBtnUpdate, mBtnQuery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);
        mBtnInsert = (Button) findViewById(R.id.btn_sqlite_insert);
        mBtnInsert.setOnClickListener(this);
        mBtnDelete = (Button) findViewById(R.id.btn_sqlite_delete);
        mBtnDelete.setOnClickListener(this);
        mBtnUpdate = (Button) findViewById(R.id.btn_sqlite_update);
        mBtnUpdate.setOnClickListener(this);
        mBtnQuery = (Button) findViewById(R.id.btn_sqlite_query);
        mBtnQuery.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_sqlite_insert:
                insert();
                break;
            case R.id.btn_sqlite_delete:
                delete();
                break;
            case R.id.btn_sqlite_update:
                update();
                break;
            case R.id.btn_sqlite_query:
                query();
                break;
        }
    }

    /**
     * 插入一条记录
     */
    private void insert() {
        final String FUN = "insert ";
        LogUtils.i(TAG, FUN + "begin");

        SQLiteDatabase db = SQLiteDBHelper.getDB();
        ContentValues values;
        for (int i = 0; i < 4; i++) {
            values = new ContentValues();
            values.put("name", "chen" + i);//TEXT
            values.put("age", (10 + i));//INTEGER
            values.put("sex", i % 2);//INTEGER
            values.put("city", "sz" + i);//TEXT
            values.put("height", 10.1 + i);//REAL
            db.insert("people", null, values);
        }
        LogUtils.i(TAG, FUN + "end");
    }

    /**
     * 删除一条记录
     */
    private void delete() {
        final String FUN = "delete ";
        LogUtils.i(TAG, FUN + "begin");

        SQLiteDatabase db = SQLiteDBHelper.getDB();
        db.delete("people", null, null);
        LogUtils.i(TAG, FUN + "end");
    }

    /**
     * 更新一条记录
     */
    private void update() {
        final String FUN = "update ";
        LogUtils.i(TAG, FUN + "begin");

        SQLiteDatabase db = SQLiteDBHelper.getDB();
        //db.execSQL("update from people set name ='update' where age=12");
        ContentValues values = new ContentValues();
        values.put("name", "update");
        db.update("people", values, "age=?", new String[]{"12"});
        LogUtils.i(TAG, FUN + "end");
    }

    /**
     * 查询一条记录
     */
    private void query() {
        final String FUN = "query ";
        LogUtils.i(TAG, FUN + "begin");

        SQLiteDatabase db = SQLiteDBHelper.getDB();
        //Cursor cursor = db.rawQuery("select * from people", new String[] {});
        Cursor cursor = db.query("people", null, null, null, null, null, null);
        if (cursor != null) {
            int count = cursor.getCount();
            LogUtils.i(TAG, "count=" + count);
            if (count > 0) {
                boolean b = cursor.moveToFirst();
                String result = "\n";
                while (b) {
                    String name = cursor.getString(cursor.getColumnIndex("name"));
                    int age = cursor.getInt(cursor.getColumnIndex("age"));
                    int sex = cursor.getInt(cursor.getColumnIndex("sex"));
                    String city = cursor.getString(cursor.getColumnIndex("city"));
                    double height = cursor.getDouble(cursor.getColumnIndex("height"));
                    result = result
                            + "name="
                            + name
                            + ",age="
                            + age
                            + ",sex="
                            + sex
                            + ",city="
                            + city
                            + ",height="
                            + height
                            + "\n";
                    b = cursor.moveToNext();
                }
                LogUtils.i(TAG, "query result:" + result);
            }
        } else {
            LogUtils.i(TAG, "query cursor == null");
        }
        LogUtils.i(TAG, FUN + "end");
    }
}
