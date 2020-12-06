package com.jsg.examples.spring;

import com.jsg.examples.spring.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

    public static void main(String[] args) {
/*        ApplicationContext ac=new FileSystemXmlApplicationContext("D:\\WorkSpace\\spring\\work\\src\\main\\resources\\test\\bean.xml");
        User user= (User) ac.getBean("user");
        user.add();*/

        ApplicationContext bc=new ClassPathXmlApplicationContext("/spring/bean.xml");
        User us= (User) bc.getBean("user");
        us.add();
    }
}
