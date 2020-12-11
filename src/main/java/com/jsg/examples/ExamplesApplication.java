package com.jsg.examples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ExamplesApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExamplesApplication.class, args);
    }

}
