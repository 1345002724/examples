package com.jsg.examples.spring.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration //声明作为配置类，替代xml配置
@ComponentScan(basePackages = {"com.jsg.examples.spring"}) //注解扫描
//@EnableAspectJAutoProxy(proxyTargetClass = true) // <!--开启Aspect生成代理对象，等同于<aop:aspectj-autoproxy></aop:aspectj-autoproxy>-->
public class springconfig {
}
