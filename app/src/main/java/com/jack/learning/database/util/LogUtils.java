package com.jack.learning.database.util;

import android.util.Log;

/**
 * author: jack
 * date: 2018/8/28 19:18
 * desc:log
 */
public class LogUtils {
    private static final String TAG = "LogUtils";

    //Log等级
    private static final int LEVEL_ERROR = 1;
    private static final int LEVEL_WARN = 2;
    private static final int LEVEL_INFO = 3;
    private static final int LEVEL_DEBUG = 4;
    private static final int LEVEL_VERBOSE = 5;

    //当前LOG等级，发布时-LEVEL_DEBUG，调试时-LEVEL_VERBOSE
    private static final int LOG_LEVEL = LEVEL_VERBOSE;
    private static final String DEFAULT_TAG = "[Database] ";

    /**
     * 错误级别
     */
    public static void e(String tag, String info) {
        if (LOG_LEVEL >= LEVEL_ERROR) {
            Log.e(DEFAULT_TAG + tag, info);
        }
    }

    /**
     * 警告级别
     */
    public static void w(String tag, String info) {
        if (LOG_LEVEL >= LEVEL_WARN) {
            Log.w(DEFAULT_TAG + tag, info);
        }
    }

    /**
     * 普通信息
     */
    public static void i(String tag, String info) {
        if (LOG_LEVEL >= LEVEL_INFO) {
            Log.i(DEFAULT_TAG + tag, info);
        }
    }

    /**
     * 调试级别
     */
    public static void d(String tag, String info) {
        if (LOG_LEVEL >= LEVEL_DEBUG) {
            Log.d(DEFAULT_TAG + tag, info);
        }
    }

    /**
     * verbose级别
     */
    public static void v(String tag, String info) {
        if (LOG_LEVEL >= LEVEL_VERBOSE) {
            Log.v(DEFAULT_TAG + tag, info);
        }
    }

}
