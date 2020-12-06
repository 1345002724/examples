package com.jsg.examples.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAop {
    public static void main(String[] args) {
        ApplicationContext bc=new ClassPathXmlApplicationContext("/spring/bean.xml");
        com.jsg.examples.spring.aop.UserImpl us= (UserImpl) bc.getBean("userimpl");
        us.add1(10,5); //before测试
        us.add2();//after测试
    }
}
