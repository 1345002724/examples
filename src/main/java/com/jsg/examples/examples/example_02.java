package com.jsg.examples.examples;

import java.io.*;


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
        byte[] b1=new byte[1024];
        InputStream in=new FileInputStream(file);
        in.read(b1);
        in.close();
        System.out.println(new String(b1));
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



    //编写测试类
    public static void main(String[] args) throws IOException {
        example_02 ex=new example_02();
        //判断文件是否存在、以及创建文件
        ex.test01("D:\\test.txt");
        //测试写入字符串
        ex.test03("测试文件写入、读取");
        //读取文件
        ex.test02("D:\\test.txt");

    }
}
