package com.jsg.examples.utils;
import java.io.UnsupportedEncodingException;
import java.util.Base64;

public  class Base64_util {

    //第一种不引入jar
    //base64加密
    public static String to_base64(String str) throws UnsupportedEncodingException {

            String bs64 = Base64.getEncoder().encodeToString(str.getBytes("utf-8"));
            return bs64;

            //直接返回  return  Base64.getEncoder().encodeToString(str.getBytes("utf-8"));
         }



    //base64解密
    public static String jm_base64(String str) throws UnsupportedEncodingException {

        byte[] asBytes = Base64.getDecoder().decode(str);
        return (new String(asBytes, "utf-8"));

        //直接返回 return new String(Base64.getDecoder().decode(str),"utf-8");
         }





         //第二种引入jar

    }

