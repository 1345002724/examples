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

         String str="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";
        QRCode_Str strtoQRcode=new QRCode_Str();
        String r=strtoQRcode.StrtoQRcode(str);
        System.out.println(r);
    }
}