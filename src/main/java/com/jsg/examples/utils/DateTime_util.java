package com.jsg.examples.utils;


import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;

import java.text.ParseException;
import java.util.Date;

/**
 *需要引用的jar
     <dependency>
     <groupId>commons-lang</groupId>
     <artifactId>commons-lang</artifactId>
     <version>2.6</version>
     </dependency>
 */
public class DateTime_util {


    //返回（获取）当前时间毫秒
    public static long getHm(){

        long lg=System.currentTimeMillis();
        return lg;
        //直接返回（返回类型long） return System.currentTimeMillis();
    }


    //返回String类型的当前时间(date转String)
    public static String getTodayDay()
    {
        //方式一：
        //return DateFormatUtils.format(System.currentTimeMillis(), "yyyy-MM-dd HH:mm:ss");
        //方式二：
        return DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss");
    }


    //String转date
    public static Date getDate(String str) throws ParseException {
        return  DateUtils.parseDate(str,new String[] { "yyyy-MM-dd HH:mm:ss" });
    }


    public static void main(String[] args) throws ParseException {
        System.out.println(DateTime_util.getTodayDay());
        String str="2020-10-10 10:10:10";
        Date date=DateUtils.parseDate(str,new String[] { "yyyy-MM-dd HH:mm:ss" });
        System.out.println(date);
    }
}
