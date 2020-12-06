package com.jsg.examples.utils;

import cn.hutool.crypto.SecureUtil;
import org.springframework.util.DigestUtils;
import java.io.UnsupportedEncodingException;

/**
 * 默认为32位加密
 * 如果需要16位加密则在32位返回后面加上.substring(8, 24)
 */
public class Md5_util {
    /**
     * 方式一:用Spring帮我们封装
     * 入参需要加密的字符串，返回字符串
     * 即String md5Str = DigestUtils.md5DigestAsHex("字符串".getBytes("UTF-8"));
     * 如果需要16位加密则在其后面加上.substring(8, 24)
     */
    public static String test01(String str) throws UnsupportedEncodingException {
        String md5Str = DigestUtils.md5DigestAsHex(str.getBytes("UTF-8"));
        return md5Str;
    }

    /**
     * 方式二:导入hutool工具包
     * 入参需要加密的字符串，返回字符串
     * 即使用String md5Str = SecureUtil.md5(str);
     * 如果需要16位加密则在其后面加上.substring(8, 24)
     */
    public static String test02(String str)  {
        String md5Str = SecureUtil.md5(str);
        return md5Str;
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        String str1="fdsfsdfsdfsd";

       String result1= Md5_util.test01(str1);
        System.out.println("第一种32位方式加密"+result1);
        System.out.println("第二种方式16位加密"+result1.substring(8, 24));

        String result2=Md5_util.test02(str1);
        System.out.println("第二种方式32位加密"+result2);
        System.out.println("第二种方式16位加密"+result2.substring(8, 24));
    }
}
