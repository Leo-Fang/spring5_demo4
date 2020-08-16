package com.atguigu.spring5.aopanno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author Leo
 * @date 2020/7/27 - 19:24
 */

//增强的类
@Component
@Aspect //生成代理对象
@Order(3)
public class UserProxy {

    //相同切入点的抽取
    @Pointcut(value = "execution(* com.atguigu.spring5.aopanno.User.add(..))")
    public void pointDemo() {}

    //前置通知，在方法之前执行
    @Before(value = "pointDemo()")
    public void before() {
        System.out.println("before...");
    }

    //后置通知（返回通知），在返回结果后执行，当方法有异常就不执行
    @AfterReturning(value = "execution(* com.atguigu.spring5.aopanno.User.add(..))")
    public void afterReturning() {
        System.out.println("afterReturning...");
    }

    //最终通知，方法之后就执行
    @After(value = "execution(* com.atguigu.spring5.aopanno.User.add(..))")
    public void after() {
        System.out.println("after...");
    }

    //异常通知，当方法有异常才执行
    @AfterThrowing(value = "execution(* com.atguigu.spring5.aopanno.User.add(..))")
    public void afterThrowing() {
        System.out.println("AfterThrowing...");
    }

    //环绕通知，在方法之前和之后都执行
    @Around(value = "execution(* com.atguigu.spring5.aopanno.User.add(..))")
    public void arround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕之前...");
        //被增强的方法
        proceedingJoinPoint.proceed();
        System.out.println("环绕之后...");
    }

}
