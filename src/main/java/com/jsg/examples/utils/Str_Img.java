package com.jsg.examples.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.*;

/**
 * 图片转字符串
 * 字符串转图片
 */
public class Str_Img {

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
            OutputStream out = new FileOutputStream("D:/Systems/"+filename);
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
    public static String getImageStr(String filePath) {
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
    public static void main(String[] args) {

        //图片转字符串
/*        String imageStr = getImageStr("D:\\001.jpg");
        System.out.println(imageStr);*/


        //字符串转图片
        String imageStr1="iVBORw0KGgoAAAANSUhEUgAAAH8AAAB/CAIAAABJ34pEAAAC+ElEQVR42u3cwXLCMAxFUf7/p+m2C6CJ3n0OqW+WdHCSY0a2JE8fT6/rrocE1+s/suvFuO//9Olp3o9MffLhXqeeGRFTX331Eyz83U5NTDjlp16H+nmpr776n0efxWJc/9Q0zNYGauTjYuqrr35JP9yizb5OhXv11Vf/Xvqz5DB8bepes92t+uqrn+svi30H7z5LcakS4T0qDeqrf1t9al+4zydf1F1RX/276WNN+jMTQ9Xuw4r/qYy9cqZBffV31V9Q1aISyNmejyoRsj7qq7+5PpW+9spb4d0XnMMYLD/qq7+5ftjkw9t11J6vt5tEagHqq7+5PrVTxOeDyqJ7DYPkT+qrrz4S6XqnCnoLwGw+kF+D+uqrz6rhJxgu6Qi2ewnqq69+u+CFLyS9TW2Y2R5HUF999ZGnpMpSYV5NrQS9yVNfffXHlfFZckgV8sI+InU2YtaCVV999fNjAfiuNAzuYdluwaEN9dVXv/pKeNkunODe3M9PU6mvvvqjzhmVrIbFtXCtWn+eQ331N9dfkEmGxfdwFntrFVDfV1999elOPyXb29SGlcHkuIP66m+uj5fa8Xi9gG82cjLl6qu/uX4vOQwL/VQLAd/LVlZd9dXfTH9BlkhF1UsCN95MVV999fMITmW/1GtTpb1wOfzz7uqrr37Szp9N3oLDBF/+LfXVVz+JhrN8GL8pPjJerVNfffXPxv3wcCRViQurfuHkhecn1Fdf/bF+7+EWEM9CealWqL766ifPNNuQhfq9Jaq3egGdRfXV30wfD4tUHku1BvEsep7rqq/+rvq9Bl64WrTzzyf3X9gq+3311f+P+mkgo3PdUyP3Mm2qb6G++ur/1keiWF40p/JP6qeDz/TrHaf66m+v34vyVEqJNwLxNoP66qs/1g9LV1SFfTYyFe6pu6uvvvpr9EPHlbeY9SyRNoP66qvf1v+2HDV8HiQ/V1999dm9Gh55e5OHEx9/ePXVV7+Uo4axONz84UsUO/fqq7+5vtcll/pXXj/dwcfSc5rQvQAAAABJRU5ErkJggg==";
        boolean generateImage = generateImage(imageStr1, "001.jpg");
        System.out.println(generateImage);
    }
}
