package com.jsg.examples.test;

import jp.sourceforge.qrcode.QRCodeDecoder;
import sun.misc.BASE64Decoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Test05 {
    public void testt() throws IOException {
        BASE64Decoder decoder = new BASE64Decoder();
        String Str="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";
        try {
            // 解密
            byte[] b = decoder.decodeBuffer(Str);
            // 处理数据
            for(int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {
                    b[i] += 256;
                }
            }
            InputStream in = new ByteArrayInputStream(b);
            BufferedImage image = ImageIO.read(in);
            QRCodeDecoder codeDecoder = new QRCodeDecoder();

            //通过解析二维码获得信息
            String result = new String(codeDecoder.decode(new MyQRCodeImage(image)), "utf-8");
            System.out.println(result);

            } catch (Exception e){
            e.printStackTrace();
        }

        }

    public static void main(String[] args) throws IOException {
        Test05 ts=new Test05();
        ts.testt();
    }
    }

