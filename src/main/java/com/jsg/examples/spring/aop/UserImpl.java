package com.jsg.examples.spring.aop;

import org.springframework.stereotype.Component;

@Component(value = "userimpl")
//public class UserImpl implements User{
    public class UserImpl {
    public int add1(int a,int b) {

        System.out.println("add1方法执行了..........");
        System.out.println(a+b);
        return a+b;
    }

    public void add2() {
        System.out.println("add2方法执行了..........");
    }
}
