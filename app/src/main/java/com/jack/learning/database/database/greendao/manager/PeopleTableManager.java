package com.jack.learning.database.database.greendao.manager;


import com.jack.learning.database.database.greendao.code.PeopleTableDao;
import com.jack.learning.database.database.greendao.table.PeopleTable;
import com.jack.learning.database.util.LogUtils;

import java.util.List;


/**
 * author : jack
 * date : 2018/10/28 21:22
 * desc : 通话记录表管理类
 */
public class PeopleTableManager {
    private static final String TAG = "PeopleTableManager";
    private PeopleTableDao peopleTableDao;

    public PeopleTableManager(PeopleTableDao peopleTableDao) {
        this.peopleTableDao = peopleTableDao;
    }

    /**
     * 插入，插入记录
     */
    public void insert() {
        final String FUN = "insert ";
        LogUtils.i(TAG, FUN + "begin");

        PeopleTable people;
        for (int i = 0; i < 5; i++) {
            people = new PeopleTable();
            people.setUid(i);
            people.setName("chen" + i);
            people.setAge(10 + i);
            peopleTableDao.insert(people);
        }
        LogUtils.i(TAG, FUN + "end");
    }

    /**
     * 删除记录,删除记录
     */
    public void delete() {
        final String FUN = "delete ";
        LogUtils.i(TAG, FUN + "begin");

        PeopleTable people =
                peopleTableDao.queryBuilder().where(PeopleTableDao.Properties.Age.eq(14)).build().unique();
        if (people != null) {
            peopleTableDao.deleteByKey(people.getId());
        }
        LogUtils.i(TAG, FUN + "end");
    }

    /**
     * 更新表，查找记录-修改-保存
     */
    public void update() {
        final String FUN = "update ";
        LogUtils.i(TAG, FUN + "begin");

        List<PeopleTable> list = peopleTableDao.queryBuilder().where(PeopleTableDao.Properties.Age.eq(13)).build().list();
        PeopleTable people = null;
        if (list != null && list.size() > 0) {
            people = list.get(0);
        }
        if (people != null) {
            people.setName("Update");
            peopleTableDao.update(people);
        }
        LogUtils.i(TAG, FUN + "end");
    }

    /**
     * 查询表，查找记录
     */
    public void query() {
        final String FUN = "select ";
        LogUtils.i(TAG, FUN + "begin");

        List<PeopleTable> list = peopleTableDao.queryBuilder().build().list();
        if (list != null && list.size() > 0) {
            String result = "\n";
            for (PeopleTable people : list) {
                result = result + people + "\n";
            }
            LogUtils.i(TAG, "query result:" + result);
        } else {
            LogUtils.i(TAG, "query result:null");
        }
        LogUtils.i(TAG, FUN + "end");
    }

}
