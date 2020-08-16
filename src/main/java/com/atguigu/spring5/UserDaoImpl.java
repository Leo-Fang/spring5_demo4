package com.atguigu.spring5;

/**
 * @author Leo
 * @date 2020/7/27 - 15:55
 */

public class UserDaoImpl implements UserDao {

    @Override
    public int add(int a, int b) {
        System.out.println("add方法执行了...");
        return a+b;
    }

    @Override
    public String update(String id) {
        System.out.println("update方法执行了...");
        return id;
    }

}
