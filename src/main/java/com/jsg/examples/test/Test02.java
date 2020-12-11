package com.jsg.examples.test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Test02 {
    public static void main(String[] args) {
        List<String> str = new ArrayList<String>();
        str.add("张三");
        str.add("李四");
        for (String str2 : str) {
            System.out.println(str2);
        }

        for(int i=0;i<str.size();i++)
        {
            System.out.println("i="+i);
        }

        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        System.out.println(uuid);
    }


}
