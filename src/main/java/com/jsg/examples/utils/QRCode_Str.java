package com.jsg.examples.utils;


import jp.sourceforge.qrcode.QRCodeDecoder;
import sun.misc.BASE64Decoder;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * （其子类MyQRcodeImage）
 * 2、从图片字符串里面直接解析二维码内容
 */

public class QRCode_Str {

    /**
     * 1、从图片字符串里面直接解析二维码内容
     * 2、返回二维码的内容
     */
    public String StrtoQRcode(String str) throws IOException {
        BASE64Decoder decoder = new BASE64Decoder();

               try {
            // 解密
            byte[] b = decoder.decodeBuffer(str);
            // 处理数据
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {
                    b[i] += 256;
                }
            }
            //输入流读取的数据保存在该字节数组缓冲区
            InputStream in = new ByteArrayInputStream(b);
            BufferedImage image = ImageIO.read(in);
            QRCodeDecoder codeDecoder = new QRCodeDecoder();

            //通过解析二维码获得信息
            String result = new String(codeDecoder.decode(new MyQRCodeImage(image)), "utf-8");
            return result;

        } catch (Exception e) {
            e.printStackTrace();
            return "解析失败";
        }
    }


    public static void main(String[] args) throws IOException {

         String str="iVBORw0KGgoAAAANSUhEUgAAAH8AAAB/CAIAAABJ34pEAAADD0lEQVR42u3dS3LCMBBFUfa/aTLMIBWQ+91ugXU9JGDko5TUH6XyeHrtux4S7Nd/ZNfv7f688uq7Fz6+csNL73kx+NrAEjH11Vd/Xa2GtfIA4TTUZmhlGNR41Fdf/df6k6s8/tgri3u4/SBi6quvPqJPPTYeudaeK9zG1Fdf/V3rPrXyTm4J6quv/i79MIEMq1G1+4S5bqi/v9Kgvvpfq4/X92//ykd3V9RX/7P1sSZ9VjjDy/p9CTZ5pkF99U/VD7HColhfaY8aWFMIq776h+vjNayBZboW/PV9O7Drqq/+YfpUOFibPLyav+VHhZlWX331m4LIMDHeYoS3Geo1TvXVP0O/lrlRw8Xz2HCEVAz63w3VV1/9sar3QIeSXZ2v6q+/WX311Ufq+1RVKzxRgZ+Cwgv96quv/rPzz0jCvh0VMvYFrMmzq6+++oVACs82qUpcOOXhV9Tr++qrf5g+G0iBSS/+qck7v72P+uofro9HePgmMZDHhttPYczqq3+4fl8RqtZi/Ng8lj3qob766iNqVFegL4ikknkkDVZfffXZulLoSJ1notLpMAYlI0711b+j/gB6aI2Eeh2fqncW1Vf/VH3qXFRY+qfakHi7gjrd9eY0lfrqq59FVHjSS83rlu6C+uqrv1jnCUeQZIB5jY/akPBfgtVKg/rqn6E/cByq1hGkEmOq0M+eylJf/cP18WpU7QgCvqNQ9Ttq17nc11Vf/VvrhwEZBUH1//pOS6ivvvqt+lROSNXCJo8p4C3Peryvvvq31g9r92wG+Jz9D2RhkS7Jz9VX/3B9KtukMuQwyaR2gtqb14ehvvrqs6FeuARTxb4wmsRPXdRzXfXVv6P+gAj+IyobD6cqeY/66h+uP7DS9RXg8PpdbT4Kc6a++uonp6kGAruBPHYgeb4c76uv/mH6FAS1zlJVv7CBQW2Q6quvfkdhnZqYsKXXN/fITKuvvvpN+uGRCOqEUzgeavNTX331O3Ldvkeiep/U7xCykaivvvpsfb+2lFOl/4GyHdLJUF/9w/W9tlzq77x+AGcfniaS1htCAAAAAElFTkSuQmCC";

        QRCode_Str strtoQRcode=new QRCode_Str();
        String r=strtoQRcode.StrtoQRcode(str);
        System.out.println(r);
    }
}