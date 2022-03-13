package com.jsg.examples.service;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jsg.examples.entity.CommonResult;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Service
public class NeusoftService {

    public void trade5303(Map<String, Object> resParam,CommonResult result) {
        //第一步调用5303交易获取病人在院信息
        String ls_jgid = (String) resParam.get("fixmedins_code");
        String startime = (String) resParam.get("starttime");
        String endtime = (String) resParam.get("endtime");
        String param=(String) resParam.get("param");

        //拼装5303请求入参
        JSONObject root = new JSONObject();
        JSONObject data = new JSONObject();
        JSONObject input = new JSONObject();
        Date now = new Date();
        root.put("infno","5303");
        root.put("msgid",String.format(ls_jgid, toLine(now)));
        root.put("mdtrtarea_admvs","500153");
        root.put("insuplc_admdvs","500153");
        root.put("recer_sys_code","YBXT");
        root.put("dev_no","");
        root.put("dev_safe_info","");
        root.put("cainfo","");
        root.put("signtype","");
        root.put("infver","V1.0");
        root.put("opter_type","1");
        root.put("opter","9803");
        root.put("opter_name","创业");
        root.put("inf_time",toString(now));
        root.put("fixmedins_code",ls_jgid);
        root.put("fixmedins_name", "忠县基层医疗卫生服务中心");
        root.put("input",input);
        input.put("data",data);
        data.put("psn_no","");
        data.put("begntime",startime);
        data.put("endtime",endtime);


        JSONObject trade=new JSONObject();
        JSONObject in=new JSONObject();
        trade.put("method","BUSINESS_HANDLE");
        trade.put("serviceId","SiInterface_hsf");
        trade.put("parameters",in);
        in.put("in",root);

        //发送http请求解析数据
        String HttpResult = HttpUtil.post("http://127.0.0.1:9527/dll/call", trade.toString());
        JSONObject JSONObject1 = JSON.parseObject(HttpResult);
        JSONArray ss = (JSONArray) JSONObject1.get("body");
        JSONArray ss1 = (JSONArray) ss.get(0);
        JSONObject jsonObject2 = JSON.parseObject((String) ss1.get(0));
        JSONObject JSONObject3 = (JSONObject) jsonObject2.get("output");

        if(jsonObject2.get("infcode").equals("1")){
            result.setCode(500);
            result.setMessage("失败");
            result.setData(HttpResult);
        }

        JSONArray JSONArray1 = (JSONArray) JSONObject3.get("data");
        JSONArray jsonArray2 = new JSONArray();
        if (param != "" || param != null) {
            for (int i = 0; i < JSONArray1.size(); i++) {
                JSONObject jsonObject4 = (JSONObject) JSONArray1.get(i);
                String temp = jsonObject4.get("psn_name").toString();
                if (temp.contains(param)) {
                    jsonArray2.add(JSONArray1.get(i));
                }

            }

        }
        JSONArray jsonArray = new JSONArray();//最终返回
        if (jsonArray2.size() > 0) {
            jsonArray = jsonArray2;
        } else jsonArray = JSONArray1;
    }

    public static SimpleDateFormat formater_line=new SimpleDateFormat("yyyyMMddHHmmssSSS");
    public static String toLine(Date date) {
        return formater_line.format(date);
    }

    public static SimpleDateFormat formater_default=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static String toString(Date date) {
        return formater_default.format(date);
    }
}
