package com.jsg.examples.test;

import java.util.*;

public class Test_07 {
    public static void main(String[] args) {
        Map<String,Object> map = new HashMap();
        map.put("张三", "22");
        map.put("李四", "30");
        for(String s:map.keySet()){
            System.out.println(s);
            System.out.println(map.get(s));
        }

        for(Map.Entry<String, Object> entry:map.entrySet()){
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());

        }
    }
    public void methods1() {


    }

     static class classb {
        public static void methods2(){
            System.out.println("ssssb");
        }
        public void main(String[] args) {
            System.out.println("sssss");
        }
    }
}





