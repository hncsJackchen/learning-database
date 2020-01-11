package com.jack.learning.database.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jack.learning.database.R;
import com.jack.learning.database.database.greendao.DBInterface;
import com.jack.learning.database.database.greendao.manager.PeopleTableManager;

public class GreenDaoActivity extends Activity implements View.OnClickListener {
    private static final String TAG = "GreenDaoActivity";
    private Button mBtnInsert, mBtnDelete, mBtnUpdate, mBtnQuery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_green_dao);
        mBtnInsert = (Button) findViewById(R.id.btn_greendao_insert);
        mBtnInsert.setOnClickListener(this);
        mBtnDelete = (Button) findViewById(R.id.btn_greendao_delete);
        mBtnDelete.setOnClickListener(this);
        mBtnUpdate = (Button) findViewById(R.id.btn_greendao_update);
        mBtnUpdate.setOnClickListener(this);
        mBtnQuery = (Button) findViewById(R.id.btn_greendao_query);
        mBtnQuery.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        PeopleTableManager contactTableManager = DBInterface.getInstance().getContactTableManager();
        switch (v.getId()) {
            case R.id.btn_greendao_insert:
                contactTableManager.insert();
                break;
            case R.id.btn_greendao_delete:
                contactTableManager.delete();
                break;
            case R.id.btn_greendao_update:
                contactTableManager.update();
                break;
            case R.id.btn_greendao_query:
                contactTableManager.query();
                break;
        }
    }
}
