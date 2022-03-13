package com.jsg.examples.utils;


import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;


/**
 * 入参自己填
 * http工具
 */
public class Http_Yb_Test
{
    private static final Logger logger = LoggerFactory.getLogger(com.jsg.examples.utils.http请求.HttpClientUtil.class);


    /*********************************入参自己填写********************************/
    public static String doPost_xxcf(String url, String param,String cookie,String token) {
        // 创建Httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        String resultString = "";
        try {
            // 创建Http Post请求
            HttpPost httpPost = new HttpPost(url);

            RequestConfig requestConfig = RequestConfig.custom()
                    .setConnectTimeout(6000).setConnectionRequestTimeout(6000)
                    .setSocketTimeout(6000).build();
            httpPost.setConfig(requestConfig);
//            httpPost.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
  //          httpPost.setHeader("Content-type", "application/json; charset=utf-8");


            httpPost.setHeader("Accept", "application/json, text/plain, */*");
            httpPost.setHeader("Accept-Encoding", "gzip, deflate");
            httpPost.setHeader("Accept-Language", "zh-CN,zh;q=0.9");
            httpPost.setHeader("Connection", "keep-alive");
//            httpPost.setHeader("Content-Length", "180");
            httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");

            httpPost.setHeader("Cookie", cookie);

            httpPost.setHeader("Host", "10.123.46.1");
            httpPost.setHeader("Origin", "http://10.123.46.1");
            httpPost.setHeader("Referer", "http://10.123.46.1/hds/N1702.html");
            httpPost.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/94.0.4606.71 Safari/537.36");
            httpPost.setHeader("X-XSRF-TOKEN",token );

            // 创建参数列表
            if (param != null) {
                StringEntity entity = new StringEntity(param);
                httpPost.setEntity(entity);
            }
            // 执行http请求
            response = httpClient.execute(httpPost);
            resultString = EntityUtils.toString(response.getEntity(), "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return resultString;
    }





}
