package com.jsg.examples;

import com.google.common.collect.Lists;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.servlet.HandlerInterceptor;
import sun.misc.Request;

import java.util.List;

@SpringBootApplication
@EnableCaching
public class ExamplesApplication {



    public static void main(String[] args) {
        SpringApplication.run(ExamplesApplication.class, args);



    }

}
