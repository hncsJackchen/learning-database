package com.jack.learning.database.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jack.learning.database.R;

public class MainActivity extends Activity implements View.OnClickListener {
    private static final String TAG = "MainActivity";
    private Button mBtnAndroid, mBtnGreenDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnAndroid = findViewById(R.id.btn_main_android);
        mBtnAndroid.setOnClickListener(this);
        mBtnGreenDao = findViewById(R.id.btn_main_greendao);
        mBtnGreenDao.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_main_android:
                startActivity(new Intent(this, SQLiteActivity.class));
                break;
            case R.id.btn_main_greendao:
                startActivity(new Intent(this, GreenDaoActivity.class));
                break;
        }
    }
}
