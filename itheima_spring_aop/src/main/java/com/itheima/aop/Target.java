package com.itheima.aop;

public class Target implements TargetInterface {

    @Override
    public void save() {
//        int i = 1/0;
        System.out.println("save running...");
    }
}
