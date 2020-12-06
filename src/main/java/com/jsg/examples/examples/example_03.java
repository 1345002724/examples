package com.jsg.examples.examples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class example_03 {
    /**
     * 循环遍历数组
     * @param args
     */
    public static void main(String[] args) {
        /** 遍历list  **/
        List<String> str = new ArrayList<String>();
        str.add("张三");
        str.add("李四");
        for (String str2 : str) {
            System.out.println(str2);
        }

        /** 遍历map  **/
        Map<String,String> map=new HashMap<>();
        map.put("name","张三1");
        map.put("name","张三2");
        map.put("name","张三3");
        for (Map.Entry<String,String> entry : map.entrySet()) {
            System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
        }

    }
}
