package com.jsg.examples.task;


import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
//@EnableScheduling
public class TokenTask2 {

    @Scheduled(fixedRate = 2000)
    public void start(){
        System.out.println("定时器每2秒执行一次");
    }
    
}

