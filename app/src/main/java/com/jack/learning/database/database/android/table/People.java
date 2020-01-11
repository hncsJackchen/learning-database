package com.jack.learning.database.database.android.table;

/**
 * Author： Jackchen
 * Time： 2016/11/29
 * Description:
 */
public class People implements Comparable<People> {
    private Long id;
    private int uid;
    private String name;
    private int age;
    private boolean sex;

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
    public int compareTo(People another) {
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
