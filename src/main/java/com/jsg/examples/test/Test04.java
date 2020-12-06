package com.jsg.examples.test;

import jp.sourceforge.qrcode.QRCodeDecoder;
import jp.sourceforge.qrcode.data.QRCodeImage;
import sun.misc.BASE64Decoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Test04 {


    public static void main(String[] args) {
        // Result result = null;
        BASE64Decoder decoder = new BASE64Decoder();
        byte[] b = new byte[0];

        String imageStr="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";

        try {
            b = decoder.decodeBuffer(imageStr);
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {
                    b[i] = (byte) (b[i] + 256);
                }
            }

            InputStream in = new ByteArrayInputStream(b);
            BufferedImage image = ImageIO.read(in);
            QRCodeDecoder decoder1 = new QRCodeDecoder();
            String content = new String(decoder1.decode((QRCodeImage) image), "utf-8");
            System.out.println(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
