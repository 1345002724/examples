package com.jsg.examples.utils;
import java.io.UnsupportedEncodingException;
import java.util.Base64;

public  class Base64_util {

    //第一种不引入jar
    //base64加密
    public static String to_base64(String str) throws UnsupportedEncodingException {

            String bs64 = Base64.getEncoder().encodeToString(str.getBytes("utf-8"));
            return bs64;

            //直接返回  return  Base64.getEncoder().encodeToString(str.getBytes("utf-8"));
         }



    //base64解密
    public static String jm_base64(String str) throws UnsupportedEncodingException {

        byte[] asBytes = Base64.getDecoder().decode(str);
        return (new String(asBytes, "utf-8"));

        //直接返回 return new String(Base64.getDecoder().decode(str),"utf-8");
         }





         //第二种引入jar


    //测试
    public static void main(String[] args) {

        String str="iVBORw0KGgoAAAANSUhEUgAAAH8AAAB/CAIAAABJ34pEAAADDklEQVR42u3dSZLjMAwFUd//0q5tLTyQ+AlKDqSW3bYsPipIDIzux9PruushwfX6j+x6cd/3n/nwrU8PunCfrd/aGs7W19fF1FdffURkRT+0XvnR4iq8c2dkXOqrr/7X0W6ts7V1f2VIW/NKPXPt/fj66+qrr36Tfhirhd8Kl3v11Vf/t/SpdBFfyqmtRX311e/Q71v7akZ9e0wY+N6o0qC++j+rH9b3B/7Jjbor6qv/a/pYkx4KT2uRa18e23umQX31p+qfrGpRDcVwhsIMGfFRX/3h+ifrU+EZAkptKzEO95h3f6W++sP1+8pbtUHWpjOMgMM7A/V99dUfpl8L0WqjxZdXav8IX52tsauvvvr5uoYHiHhe3TflyX3UV3+4PhXYhVHggY5g33GHQnqvvvrqs+cVauFpbSPB01cqP69X2dRXf6o+VcwKY1C8hRD+OnsSQn311e+OscJtA6mng+EyEsKqr776bKx2YAMIX4KwpoY8qvrqD9fvi9XCYhY+i1RzApkY9dUfrk89ATVV4TSEpX/qJajnuuqrP0Mfjx2RhyuX9qipwk9vqK+++oudxb5iFlWxos5gUeer1rNx9dVXHxkkVY2isA50KJMBqq/+cH0qQOw7FkBFgXgHIrmh+uoP1+8704AXzamzCGFIjXxYffWH64cVdmpV7evtnTyrsf5+qK+++uxiSgWaVHRLFeDYb6mvvvpJoEllm2wmecNqnfrqq79bZaPiub6Ukopu8Ybi9q6rvvrqH1x5w/2DTUR3Y+LC/qG++uongSZVzKKmnDocdug0lfrqq19K/MJDVHgzIExf8V0H6K6or/4wfbzqfSAc7JtOakdRX331wQsvk1EbUrhbUM1L9dVX/78+ta5RRXwq/wxfHTwQfx1xqq/+eP2TkeKBMwT43FOTp7766j87/zEjJCd8dv5f12E0mTyY+uqrz+pTq2pfv+FAp3M711VfffWh1Zkqt4WNSTxnRvJz9dVX/3ystvWZ8DEueXj11Vf/TH2fWoKpriFbjgcLi+qrr77XVZf6V15/ZHVcPunOHa8AAAAASUVORK5CYII=";

        try {

            System.out.println(jm_base64(str));

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    }

