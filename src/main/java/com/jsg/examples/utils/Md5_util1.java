package com.jsg.examples.utils;
import java.security.MessageDigest;

/**
 * 使用jdk自带jar包，自己写实现类
 */

public class Md5_util1 {

        public static String encrypt32(String encryptStr) {
            MessageDigest md5;
            try {
                md5 = MessageDigest.getInstance("MD5");
                byte[] md5Bytes = md5.digest(encryptStr.getBytes());
                StringBuffer hexValue = new StringBuffer();
                for (int i = 0; i < md5Bytes.length; i++) {
                    int val = ((int) md5Bytes[i]) & 0xff;
                    if (val < 16)
                        hexValue.append("0");
                    hexValue.append(Integer.toHexString(val));
                }
                encryptStr = hexValue.toString();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            return encryptStr;
        }


        public static String encrypt16(String encryptStr) {
            return encrypt32(encryptStr).substring(8, 24);
        }

        public static void main(String[] args) {
            String encryptStr = "fdsfsdfsdfsd";
            System.out.println(Md5_util1.encrypt32(encryptStr));
            System.out.println(Md5_util1.encrypt16(encryptStr));
        }
    }

