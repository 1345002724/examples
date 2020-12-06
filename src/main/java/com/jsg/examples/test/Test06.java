package com.jsg.examples.test;

import java.util.UUID;

public class Test06 {
    //得到32位的uuid
/*    public static String getUUID32(){

        return UUID.randomUUID().toString().replace("-", "").toLowerCase();

    }*/



    //得到指定数量的UUID，以数组的形式返回
    public static String[] getUUID(int num){

        if( num <= 0)
            return null;

        String[] uuidArr = new String[num];

        for (int i = 0; i < uuidArr.length; i++) {
            uuidArr[i] = getUUID32();
        }

        return uuidArr;
    }

    //得到32位的uuid
    public static String getUUID32(){
        return UUID.randomUUID().toString().replace("-", "").toLowerCase();

    }

    public static void main(String[] args) {
        Test06.getUUID(10);
        String[] s=Test06.getUUID(10);

        for(int i=0;i<s.length;i++)
        {
            System.out.println(s[i]);//输出结果 1 2 3
        }
        System.out.println(Test06.getUUID32());
    }

}
