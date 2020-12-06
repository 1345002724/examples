package com.jsg.examples.test;

public class Test01 implements Test01_02 {
    public static void main(String[] args) {
        Test01_02 ts = new Test01();
        ts.test01();
    }

    @Override
    public void test01() {
        System.out.println("try-catch开始");
        try {
            int a=4;
            int b=2;
            int c=a/b;
            System.out.println(c);
        } catch (Exception e) {
            System.out.println(e);
        }finally {
            System.out.println("掉不掉finally？");
        }

    }
}
