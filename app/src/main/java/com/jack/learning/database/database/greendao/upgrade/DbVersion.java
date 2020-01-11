package com.jack.learning.database.database.greendao.upgrade;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * author: jack
 * date: 2018/10/7 17:21
 * desc: 数据库版本
 */
public class DbVersion {
    public static final SortedMap<Integer, IUpgrade> ALL_MIGRATIONS = new TreeMap<>();

    static {
        //进行版本升级时，数据库操作代码添加在这里
        ALL_MIGRATIONS.put(2, new UpgradeV2());
//        ALL_MIGRATIONS.put(3, new UpgradeV3());
    }
}
