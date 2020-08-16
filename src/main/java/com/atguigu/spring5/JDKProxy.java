package com.atguigu.spring5;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @author Leo
 * @date 2020/7/27 - 15:57
 */

public class JDKProxy {

    public static void main(String[] args) {
        //创建接口实现类代理对象
        Class[] interfaces = {UserDao.class};

        /*Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), interfaces, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return null;
            }
        });*/
        UserDaoImpl userDao = new UserDaoImpl();
        //利用动态代理创建接口实现类的代理对象
        UserDao dao = (UserDao) Proxy.newProxyInstance
                (JDKProxy.class.getClassLoader(), interfaces, new UserDaoProxy(userDao));
        int result = dao.add(1, 2);
        System.out.println("result=" + result);
    }

}

//创建代理对象，实现InvocationHandler接口
class UserDaoProxy implements InvocationHandler {

    //创建的是谁的代理对象，就把谁传递过来
    //有参数构造传递
    private Object obj;
    public UserDaoProxy(Object obj) {
        this.obj = obj;
    }

    //增强的逻辑
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //方法之前
        System.out.println("方法之前执行..." + method.getName() + "：传递的参数" + Arrays.toString(args));
        //被增强的方法
        Object res = method.invoke(obj, args);
        //方法之后
        System.out.println("方法之后执行..." + obj);
        return res;
    }

}
