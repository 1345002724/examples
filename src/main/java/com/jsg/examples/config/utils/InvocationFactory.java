package com.jsg.examples.config.utils;


import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @ClassName: InvocationFactory
 * @Description: Invocation 工厂
 * @author --
 * @date --
 */
public class InvocationFactory
{
    private final static Logger logger = LoggerFactory.getLogger(InvocationFactory.class);

    /**
     * 获取请求参数
     * 
     * @param
     * @return
     */
    public static Map<String,Object> getInvocation(HttpServletRequest request)
    {
        Map<String,Object> resParam=new HashMap<>();

        //判断请求方式 post get
        String requestMethod  = request.getMethod();
        String invoName = "";
        
        if("GET".equals(requestMethod) || DefaultMultipartHttpServletRequest.class.isAssignableFrom(request.getClass())) {

            // 请求参数
            Map<String, String> paramMap = newMap(request.getParameterMap());
            //request.setAttribute("paramMap",paramMap);
            resParam.putAll(paramMap);

        } else {
            // 请求参数
            Map<String, Object> body = (Map<String, Object>) getPostJson(request, Map.class);
            Map<String, String> urlParams = newMap(request.getParameterMap());
            resParam.putAll(urlParams);
            resParam.put("body",body);
        }
        return resParam;
    }

    /**
     * 
     * @Title:
     * @Description: 处理request.getParameterMap()，注意只取第一个值
     * @param
     * @return
     */

    public static Map<String, String> newMap(Map<String, String[]> oldMap){
        Map<String, String> newMap = new HashMap<String, String>();
        for (Map.Entry<String, String[]> m : oldMap.entrySet()) {
            String s[]= (String[]) m.getValue();
            newMap.put(m.getKey(),s[0]);
        }
        return newMap;
    }

    /**
     *
     * @Title:
     * @Description: 获取请求的json数据
     * @param
     * @return
     */
    public static <T> T getPostJson(HttpServletRequest request, Class<T> clazz) {
        int contentLength = request.getContentLength();
        byte buffer[] = new byte[contentLength];
        for (int i = 0; i < contentLength;) {
            int readlen;
            try {
                readlen = request.getInputStream().read(buffer, i, contentLength - i);
                if (readlen == -1) {
                    break;
                }
                i += readlen;
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        String charEncoding = request.getCharacterEncoding();
        if (charEncoding == null) {
            charEncoding = "UTF-8";
        }
        //System.err.println(charEncoding);
        try {
            String jsonString = new String(buffer, charEncoding);
            T t = JSONObject.parseObject(jsonString, clazz);
            return t;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
