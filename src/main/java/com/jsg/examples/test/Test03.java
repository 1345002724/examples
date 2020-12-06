package com.jsg.examples.test;

import org.apache.commons.lang.time.DateFormatUtils;

import java.util.Date;

public class Test03 {
    public static void main(String[] args) {

    String str= DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss");
        System.out.println(str);

        System.out.println(System.currentTimeMillis());
    }

}
