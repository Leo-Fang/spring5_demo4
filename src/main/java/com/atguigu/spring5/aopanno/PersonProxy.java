package com.atguigu.spring5.aopanno;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author Leo
 * @date 2020/7/27 - 20:19
 */

@Component
@Aspect
@Order(1)
public class PersonProxy {

    @Before(value = "execution(* com.atguigu.spring5.aopanno.User.add(..))")
    public void before() {
        System.out.println("Person Before...");
    }
}
