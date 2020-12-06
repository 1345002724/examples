package com.jsg.examples.spring.entity;


public class User {

    public String username;
    public String password;
    public Book book;

    public void setBook(Book book) {
        this.book = book;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void add(){
        System.out.println("add....");
        System.out.println(username);
        System.out.println(password);
        book.addBook();
    }
}
