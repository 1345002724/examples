package com.jsg.examples.utils.http请求;
import com.alibaba.fastjson.JSON;
import com.jsg.examples.utils.http请求.param.InputParam;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 入参自己填
 * http工具
 */
public class HttpClientUtil
{
    private static final Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);


    /*********************************入参自己填写********************************/
    public static String doPost(String url, InputParam param) {
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
            httpPost.setHeader("Content-type", "application/json; charset=utf-8");
            // 创建参数列表
            if (param != null) {
                // 直接传json字符串
                String str = JSON.toJSONString(param);
                StringEntity entity = new StringEntity(str,"UTF-8");
                entity.setContentType("application/json");
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
