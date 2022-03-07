package com.jsg.examples.test;

import com.alibaba.fastjson.JSONObject;

public class Test01 implements Test01_02 {
    public static void main(String[] args) {
       // Test01_02 ts = new Test01();
       // ts.test01();
        Integer a=1;
        String c="1";
        String b=c.toString();
        System.out.println(b);


    }

    @Override
    public void test01() {
        System.out.println("try-catch开始");
        try {
            int a=4;
            int b=2;
            int c=a/b;
            int d=a*a*b;
            System.out.println(c);
            System.out.println(d);
        } catch (Exception e) {
            System.out.println(e);
        }finally {
            System.out.println("掉不掉finally？");
        }

    }
}
