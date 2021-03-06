package com.jack.learning.database.database.greendao.code;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.jack.learning.database.database.greendao.table.PeopleTable;

import com.jack.learning.database.database.greendao.code.PeopleTableDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig peopleTableDaoConfig;

    private final PeopleTableDao peopleTableDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        peopleTableDaoConfig = daoConfigMap.get(PeopleTableDao.class).clone();
        peopleTableDaoConfig.initIdentityScope(type);

        peopleTableDao = new PeopleTableDao(peopleTableDaoConfig, this);

        registerDao(PeopleTable.class, peopleTableDao);
    }
    
    public void clear() {
        peopleTableDaoConfig.clearIdentityScope();
    }

    public PeopleTableDao getPeopleTableDao() {
        return peopleTableDao;
    }

}
