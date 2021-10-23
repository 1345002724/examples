package com.jsg.examples.utils;

import java.awt.print.PrinterGraphics;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/*读取文件类*/
public class ReadFile {

    /*读取配置文件*/
    public static Map<String,String> readFile(String filepath) throws Exception {
        //也可以读取指定目录下的指定文件
        InputStream in = new FileInputStream(new File(filepath));
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        Properties props = new Properties();
        props.load(br);
        Map<String, String> map = new HashMap<String, String>();
        for(Object s: props.keySet()){
            map.put(s.toString(), props.getProperty(s.toString()));
        }
        return map;
    }


    public static void main(String[] args) {
        String filepath="D:\\python\\Examples\\YB\\conf.ini";
        Map map= null;
        try {
            map = ReadFile.readFile(filepath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String token= (String) map.get("token");
        String cookie= (String) map.get("cookie");
        System.out.println(cookie);
        System.out.println(token);
    }

}
