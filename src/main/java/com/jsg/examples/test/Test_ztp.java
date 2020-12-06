package com.jsg.examples.test;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.*;

public class Test_ztp {


    /**
     * 字符串转图片
     * @param imgStr --->图片字符串
     * @param filename    --->图片名
     * @return
     */
    public static boolean generateImage(String imgStr, String filename) {

        if (imgStr == null) {
            return false;
        }
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            // 解密
            byte[] b = decoder.decodeBuffer(imgStr);
            // 处理数据
            for(int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {
                    b[i] += 256;
                }
            }
         //   System.out.println(new String(b, "utf-8"));
            OutputStream out = new FileOutputStream("src\\main\\resources\\static\\pic\\"+filename);
            out.write(b);
            out.flush();
            out.close();
            return true;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;

    }

    /**
     * 图片转字符串
     * @param filePath    --->文件路径
     * @return
     */
    public static String getImageStr(String filePath) throws UnsupportedEncodingException {
        InputStream inputStream = null;
        byte[] data = null;
        try {
            inputStream = new FileInputStream(filePath);
            data = new byte[inputStream.available()];
            inputStream.read(data);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 加密
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data);
    }

    /*
     * 测试代码
     */
    public static void main(String[] args) throws IOException {
       //String imageStr = getImageStr("D:\\001.jpg");
        //System.out.println(imageStr);
        String imageStr="iVBORw0KGgoAAAANSUhEUgAAAH8AAAB/CAIAAABJ34pEAAADD0lEQVR42u3dS3LCMBBFUfa/aTLMIBWQ+91ugXU9JGDko5TUH6XyeHrtux4S7Nd/ZNfv7f688uq7Fz6+csNL73kx+NrAEjH11Vd/Xa2GtfIA4TTUZmhlGNR41Fdf/df6k6s8/tgri3u4/SBi6quvPqJPPTYeudaeK9zG1Fdf/V3rPrXyTm4J6quv/i79MIEMq1G1+4S5bqi/v9Kgvvpfq4/X92//ykd3V9RX/7P1sSZ9VjjDy/p9CTZ5pkF99U/VD7HColhfaY8aWFMIq776h+vjNayBZboW/PV9O7Drqq/+YfpUOFibPLyav+VHhZlWX331m4LIMDHeYoS3Geo1TvXVP0O/lrlRw8Xz2HCEVAz63w3VV1/9sar3QIeSXZ2v6q+/WX311Ufq+1RVKzxRgZ+Cwgv96quv/rPzz0jCvh0VMvYFrMmzq6+++oVACs82qUpcOOXhV9Tr++qrf5g+G0iBSS/+qck7v72P+uofro9HePgmMZDHhttPYczqq3+4fl8RqtZi/Ng8lj3qob766iNqVFegL4ikknkkDVZfffXZulLoSJ1notLpMAYlI0711b+j/gB6aI2Eeh2fqncW1Vf/VH3qXFRY+qfakHi7gjrd9eY0lfrqq59FVHjSS83rlu6C+uqrv1jnCUeQZIB5jY/akPBfgtVKg/rqn6E/cByq1hGkEmOq0M+eylJf/cP18WpU7QgCvqNQ9Ttq17nc11Vf/VvrhwEZBUH1//pOS6ivvvqt+lROSNXCJo8p4C3Peryvvvq31g9r92wG+Jz9D2RhkS7Jz9VX/3B9KtukMuQwyaR2gtqb14ehvvrqs6FeuARTxb4wmsRPXdRzXfXVv6P+gAj+IyobD6cqeY/66h+uP7DS9RXg8PpdbT4Kc6a++uonp6kGAruBPHYgeb4c76uv/mH6FAS1zlJVv7CBQW2Q6quvfkdhnZqYsKXXN/fITKuvvvpN+uGRCOqEUzgeavNTX331O3Ldvkeiep/U7xCykaivvvpsfb+2lFOl/4GyHdLJUF/9w/W9tlzq77x+AGcfniaS1htCAAAAAElFTkSuQmCC";
        boolean generateImage = generateImage(imageStr, "001.jpg");
       System.out.println(generateImage);
/*
        File file = new File("src\\main\\resources\\static\\pic\\001.jpg");
        //读取图片到缓冲区
        BufferedImage bufferedImage = ImageIO.read(file);
        //QRCode解码器
        QRCodeDecoder codeDecoder = new QRCodeDecoder();

        //通过解析二维码获得信息
        String result = new String(codeDecoder.decode(new MyQRCodeImage(bufferedImage)), "utf-8");
        System.out.println(result);*/




    }
}
