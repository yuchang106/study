package com.sqsoft;

/**
 * *************************************************
 * 系统名称：安全子系统
 * 开发人员：yzy
 * 创建日期：2024/6/29  09:44
 * -------------------------------------------------
 * 业务模块：
 * 程序功能：
 * -------------------------------------------------
 */
public class Student {
    private long id;
    private String name;
    private int age;
    private String sex;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}
