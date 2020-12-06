package com.jsg.examples.examples;

/**
 * try--catch-finally方法
 */
public class example_01 {
    public void test01(int a ,int b){

        try {
           int c=a/b;

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            System.out.println("调不调finally方法");
        }
    }

    public static void main(String[] args) {
        example_01 s=new example_01();
        s.test01(4,8);
        s.test01(4,0);
    }
}


//结论无论try-catch是否发生异常，finally都会执行