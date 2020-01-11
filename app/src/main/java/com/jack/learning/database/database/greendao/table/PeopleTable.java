package com.jack.learning.database.database.greendao.table;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;

/**
 * Author： Jackchen
 * Time： 2016/11/29
 * Description:
 */
@Entity(nameInDb = "peopleTable")
public class PeopleTable implements Comparable<PeopleTable> {

    //记录ID，自增长
    @Id(autoincrement = true)
    private Long id;

    @Property(nameInDb = "uid")
    private int uid;

    @Property(nameInDb = "name")
    private String name;

    @Property(nameInDb = "age")
    private int age;

    @Property(nameInDb = "sex")
    private boolean sex;


    @Generated(hash = 1837478288)
    public PeopleTable(Long id, int uid, String name, int age, boolean sex) {
        this.id = id;
        this.uid = uid;
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    @Generated(hash = 759961211)
    public PeopleTable() {
    }


    @Override
    public String toString() {
        return "People{" +
                "id=" + id +
                ", uid=" + uid +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }

    @Override
    public int compareTo(PeopleTable another) {
        //从小->大排序
        //return this.uid-another.uid;
        return another.uid - this.uid;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getUid() {
        return this.uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean getSex() {
        return this.sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }


}
