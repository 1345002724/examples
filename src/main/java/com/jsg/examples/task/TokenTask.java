package com.jsg.examples.task;


import com.alibaba.fastjson.JSONObject;
import com.jsg.examples.entity.CommonResult;
import com.jsg.examples.utils.ReadFile;
import com.sun.media.jfxmedia.logging.Logger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

import static com.jsg.examples.utils.Http_Yb_Test.doPost_xxcf;


@Configuration
public class TokenTask {

    public String token;
    public String cookie;
    private ScheduledExecutorService executor= null;

    @PostConstruct
    public void init(){
        start();
    }

    /*开启循环方法*/
    public void start(){
        if(executor==null){
            executor=Executors.newSingleThreadScheduledExecutor();
            ScheduledFuture<?> scheduledFuture = executor.scheduleAtFixedRate(new Runnable() {
                @Override
                public void run() {

    /************************************循环体内的方法*************************************************/
                    //获取cookie、token
                    String filepath="E:\\python\\Examples\\YB\\conf.ini";
                    Map mapini= null;
                    try {
                        mapini = ReadFile.readFile(filepath);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    token= (String) mapini.get("token");
                    cookie= (String) mapini.get("cookie");


                    //tomcat容器默认采用了iso-8859-1的编码方法.此处将form_data里面的frontUrl编码
                  String value="http://10.123.46.1/hds/N1702.html#/N170204?_modulePartId_=17-2-4";
                    try {
                        value= new String(value.getBytes("iso-8859-1"),"utf-8");
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    Map<String, String> map=new HashMap();
                    map.put("psnNo","");
                    map.put("certno","500236199305152977");
                    map.put("psnCertType","01");
                    map.put("searchInsuEmp","true");
                    map.put("_modulePartId_","17-2-4");
                    map.put("frontUrl",value);

                    String  data="";
                    for(Map.Entry key : map.entrySet()){
                        if(data.length()>0) data+="&";
                        data += key.getKey()+"="+key.getValue();
                    }
                    String url="http://10.123.46.1/hds/back/web/commonquery/getPsnByCondition";

                    String result=doPost_xxcf(url,  data,cookie,token);


                    //*判断获取到数据没有，如果没有返回报错*//*

                    if(!(JSONObject.parseObject(result).get("code")+"").equals("0")){
                        //return  new CommonResult(400,"失败",result);
                        System.out.println("更新cookie失败，请检查");

                    }
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    System.out.println("定时器在"+sdf.format(new Date())+"进行了循环更新cookie");

       /************************************循环体内的方法*************************************************/

                }
            },0,4, TimeUnit.MINUTES);
        }
    }


    /*关闭循环方法*/
    public void stop(){
        if(executor!=null){
            executor.shutdown();
            executor=null;
        }
    }

    /*查询循环状态*/
    public boolean state(){
        return executor!=null;
    }
}
