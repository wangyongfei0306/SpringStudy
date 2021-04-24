package com.itheima.dao.impl;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class UserDaoImpl implements UserDao {

    private String username;
    private int age;

    private List<String> strList;
    private Map<String, User> userMap;
    private Properties properties;

    public UserDaoImpl() {
        System.out.println("UserDaoImpl创建...");
    }

    public UserDaoImpl(String username, int age) {
        this.username = username;
        this.age = age;
    }

    public void init() {
        System.out.println("初始化方法...");
    }

    public void destroy() {
        System.out.println("销毁方法...");
    }

    @Override
    public void save() {
//        System.out.println(username + ": " + age);
        System.out.println(strList);
        System.out.println(userMap);
        System.out.println(properties);
        System.out.println("save running...");
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setStrList(List<String> strList) {
        this.strList = strList;
    }

    public void setUserMap(Map<String, User> userMap) {
        this.userMap = userMap;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "UserDaoImpl{" +
                "username='" + username + '\'' +
                ", age=" + age +
                ", strList=" + strList +
                ", userMap=" + userMap +
                ", properties=" + properties +
                '}';
    }
}
