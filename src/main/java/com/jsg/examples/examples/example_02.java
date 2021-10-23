package com.jsg.examples.examples;

import cn.hutool.core.io.IoUtil;
import com.alibaba.fastjson.JSON;

import java.io.*;
import java.util.*;


public class example_02 {
    /**
     * 通过file类检查文件是否存在以及创建新文件
     * @param str
     */
    public void test01(String str){
        File file=new File(str);
       // System.out.println("获取文件名称:"+file.getName());
        //System.out.println("获取文件绝对路径:"+file.getAbsolutePath());
        try {
            if(file.exists()){
                System.out.println("文件存在");
                }
            else {
                file.createNewFile();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 读取文件
     * @param str
     * @throws IOException
     */
    public  void test02(String str) throws IOException {
        File file=new File(str);
        FileReader stream = new FileReader(file);


        BufferedReader reader = new BufferedReader(stream);
        FileOutputStream outputStream = new FileOutputStream("E:\\d.json");
        String s = reader.readLine();
        IoUtil.write(outputStream,"utf-8",false,"[");
        int ind =0;
        while (s!=null){
            Map<String, Object> m = new LinkedHashMap<>();
            String[] s1 = s.split("\t");
            for (int i=0;i<s1.length;i++) {
                String s2=s1[i];
                m.put("A"+i,s2);
            }
            String djson = "\n";
            ind ++;
            m.put("row",ind);
            if (ind > 1) {
                djson +=",";
            }
            djson +=    JSON.toJSONString(m);

            IoUtil.write(outputStream,"utf-8",false,djson);
            s = reader.readLine();

        }

        IoUtil.write(outputStream,"utf-8",true,"\n]");
    }


    /**
     * 向文件里面写入数据(将传入的字符串写入程序里面)
     */
    public  void test03(String str) throws IOException {
        FileOutputStream out =new FileOutputStream("D:\\test.txt");
        out.write(str.getBytes());
        out.close();
        System.out.println("写入成功");
    }




    public Map<String,String> readFile() throws Exception {
        //读取src下面config包内的配置文件config.ini
      //  InputStream in = ReadIniFile.class.getClassLoader().getResourceAsStream("config/config.ini");
        //也可以读取指定目录下的指定文件
        InputStream in = new FileInputStream(new File("D:\\conf.ini"));
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        Properties props = new Properties();
        props.load(br);
        Map<String, String> map = new HashMap<String, String>();
        for(Object s: props.keySet()){
            //System.out.println(s+":"+props.getProperty(s.toString()));
            map.put(s.toString(), props.getProperty(s.toString()));
        }
        //System.out.println(map.size());
        //String port = map.get("port");
        //System.out.println("port:" + port);
        return map;
    }






    //编写测试类
    public static void main(String[] args) throws IOException {
        example_02 ex=new example_02();
        //判断文件是否存在、以及创建文件
/*        ex.test01("D:\\test.txt");
        //测试写入字符串
        ex.test03("测试文件写入、读取");*/
        //读取文件
        ex.test02("E:\\202108106785348076776592002.txt");

/*
        //读取配置文件
          try {
            Map<String,String> map=ex.readFile();
            String token = map.get("token");
            String cookie = map.get("cookie");
            System.out.println(cookie);
        } catch (Exception e) {
            e.printStackTrace();
        }
*/


    }
}
