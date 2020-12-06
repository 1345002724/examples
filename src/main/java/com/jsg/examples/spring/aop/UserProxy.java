package com.jsg.examples.spring.aop;


import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class UserProxy {

    @Before(value ="execution(* com.jsg.examples.spring.aop.UserImpl.add1(..))")
    public void before(){

        System.out.println("before之前执行");
    }


    @After(value = "execution(* com.jsg.examples.spring.aop.UserImpl.add2(..))")
    public void after(){
        System.out.println("after之后执行");
    }
}
