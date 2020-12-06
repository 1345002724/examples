package com.jsg.examples.utils;

import java.util.UUID;

public class Random_util {
    public static void main(String[] args) {

        /**
         * 生成32位uuid
         */
        String uuid  =  UUID.randomUUID().toString();
        String uuid1  =  UUID.randomUUID().toString().replace("-","");//去掉"-"
        String uuid2  =  UUID.randomUUID().toString().replace("-","").toUpperCase();//转换成大写
        System.out.println("uuid为："+uuid);
        System.out.println("uuid1为：:"+uuid1);
        System.out.println("uuid2为："+uuid2);


        /**
         * Math.random()用法
         */
        //Math.random()方法可以生成[0,1)区间中double类型的数字，可以为0，但是小于1

        //生成[0,100)之间的整数
        Integer num=(int)(Math.random()*100);
        System.out.println("随机生成[0,100)之间的整数："+num);

        //生成[30,70)之间的整数
        Integer num1=(int)(Math.random()*40+30);
        System.out.println(num1);
    }
}
