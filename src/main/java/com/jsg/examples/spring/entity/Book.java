package com.jsg.examples.spring.entity;


import org.springframework.stereotype.Component;

@Component
public class Book {
    private String bookname;
    private String bookprice;

    public  void addBook(){
        System.out.println("调用了addbook0方法");
    }
}
