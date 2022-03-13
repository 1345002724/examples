package com.jsg.examples.controller;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jsg.examples.entity.CommonResult;
import com.jsg.examples.entity.YBLogEntity;
import com.jsg.examples.service.YBService;
import com.jsg.examples.service.impl.YbServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
@RequestMapping("/yb")
public class YbController {

    @Autowired
    YBService ybService;

    @RequestMapping("/zyxx")
    public CommonResult result(@RequestBody JSONObject JSONObject, HttpServletRequest request) {

        String ls_jgid=JSONObject.get("fixmedins_code").toString();//机构id

        String sr = String.valueOf(new StringBuffer("{\"method\":\"BUSINESS_HANDLE\",\"parameters\":{\"in\":\"{     \\\"infno\\\":\\\"5303\\\",     \\\"msgid\\\":\\\"H5002330144320210924132258\\\",     \\\"insuplc_admdvs\\\":\\\"500153\\\",     \\\"mdtrtarea_admvs\\\":\\\"500153\\\",     \\\"recer_sys_code\\\":\\\"YBXT\\\",     \\\"dev_no\\\":\\\"\\\",     \\\"dev_safe_info\\\":\\\"\\\",     \\\"cainfo\\\":\\\"\\\",     \\\"infver\\\":\\\"V1.0\\\",     \\\"opter_type\\\":\\\"1\\\",     \\\"opter\\\":\\\"9803\\\",     \\\"opter_name\\\":\\\"柳公权\\\",     \\\"inf_time\\\":\\\"2021-09-24 13:22:58\\\",     \\\"fixmedins_code\\\":\\\"H50023301443\\\",     \\\"fixmedins_name\\\":\\\"忠县新立中心卫生院（忠县新立镇计划生育生殖健康服务站）\\\",     \\\"sign_no\\\":\\\"\\\",     \\\"input\\\":{         \\\"data\\\":{             \\\"psn_no\\\":\\\"\\\",             \\\"begntime\\\":\\\"2020-01-01\\\",             \\\"endtime\\\":\\\"2020-01-02 23:59:59\\\"         }     } }\"},\"serviceId\":\"SiInterface_hsf\"}"));
        sr = sr.replace("2020-01-01", JSONObject.get("starttime").toString());
        sr = sr.replace("2020-01-02", JSONObject.get("endtime").toString());
        sr = sr.replace("H50023301443", ls_jgid);


        String result = HttpUtil.post("http://127.0.0.1:9527/dll/call", sr);
        // String result= HttpUtil.post("http://127.0.0.1:9527/dll/call",String.valueOf(JSONObject));
        JSONObject JSONObject1 = JSON.parseObject(result);
        JSONArray ss = (JSONArray) JSONObject1.get("body");
        JSONArray ss1 = (JSONArray) ss.get(0);
        JSONObject jsonObject2 = JSON.parseObject((String) ss1.get(0));
        JSONObject JSONObject3 = (com.alibaba.fastjson.JSONObject) jsonObject2.get("output");


        if(jsonObject2.get("infcode").equals("1")){
            return new CommonResult(500, "失败", result);
        }

        JSONArray JSONArray1 = (JSONArray) JSONObject3.get("data");
        JSONArray jsonArray2 = new JSONArray();
        if (JSONObject.get("param") != "" || JSONObject.get("param") != null) {
            for (int i = 0; i < JSONArray1.size(); i++) {
                JSONObject jsonObject4 = (com.alibaba.fastjson.JSONObject) JSONArray1.get(i);
                String temp = jsonObject4.get("psn_name").toString();
                if (temp.contains(JSONObject.get("param").toString())) {
                    jsonArray2.add(JSONArray1.get(i));
                }

            }

        }
        JSONArray jsonArray = new JSONArray();//最终返回
        if (jsonArray2.size() > 0) {
            jsonArray = jsonArray2;
        } else jsonArray = JSONArray1;

        //入院登记冲销
        String ls_sc = String.valueOf(new StringBuffer("{\n" +
                "  \"infno\": \"2404\",\n" +
                "  \"msgid\": \"H5002330544720210624171013\",\n" +
                "  \"insuplc_admdvs\": \"500153\",\n" +
                "  \"mdtrtarea_admvs\": \"500153\",\n" +
                "  \"recer_sys_code\": \"YBXT\",\n" +
                "  \"dev_no\": \"\",\n" +
                "  \"dev_safe_info\": \"\",\n" +
                "  \"cainfo\": \"\",\n" +
                "  \"infver\": \"V1.0\",\n" +
                "  \"opter_type\": \"1\",\n" +
                "  \"opter\": \"5012\",\n" +
                "  \"opter_name\": \"徐长卿\",\n" +
                "  \"inf_time\": \"2021-06-24 17:09:37\",\n" +
                "  \"fixmedins_code\": \"H50023305447\",\n" +
                "  \"fixmedins_name\": \"冲销专用卫生院\",\n" +
                "  \"sign_no\": \"\",\n" +
                "  \"input\": {\n" +
                "    \"data\": {\n" +
                "      \"psn_no\": \"JM2036001359\",\n" +
                "      \"mdtrt_id\": \"310052514629\"\n" +
                "    }\n" +
                "  }\n" +
                "}"));

        //住院出院状态冲销
        String ls_sc1= String.valueOf(new StringBuffer("{\n" +
                "  \"infno\": \"2405\",\n" +
                "  \"msgid\": \"H5002330544720210627101410\",\n" +
                "  \"insuplc_admdvs\": \"500153\",\n" +
                "  \"mdtrtarea_admvs\": \"500153\",\n" +
                "  \"recer_sys_code\": \"YBXT\",\n" +
                "  \"dev_no\": \"\",\n" +
                "  \"dev_safe_info\": \"\",\n" +
                "  \"cainfo\": \"\",\n" +
                "  \"infver\": \"V1.0\",\n" +
                "  \"opter_type\": \"1\",\n" +
                "  \"opter\": \"5012\",\n" +
                "  \"opter_name\": \"徐长卿\",\n" +
                "  \"inf_time\": \"2021-06-27 10:14:10\",\n" +
                "  \"fixmedins_code\": \"H50023305447\",\n" +
                "  \"fixmedins_name\": \"冲销专用卫生院\",\n" +
                "  \"sign_no\": \"\",\n" +
                "  \"input\": {\n" +
                "    \"data\": {\n" +
                "      \"mdtrt_id\": \"310052514629\",\n" +
                "      \"psn_no\": \"JM2036001359\"\n" +
                "\n" +
                "    }\n" +
                "  }\n" +
                "}"));



        JSONArray result_json=new JSONArray();
        for(int i = 0; i < jsonArray.size(); i++){
            String sc=ls_sc;
            String sc1=ls_sc1;
            sc = sc.replace("H50023305447", ls_jgid);
            sc1 = sc1.replace("H50023305447", ls_jgid);

            JSONObject ls_json= JSON.parseObject(jsonArray.getString(i));

            sc = sc.replace("JM2036001359", ls_json.get("psn_no").toString());
            sc1 = sc1.replace("JM2036001359", ls_json.get("psn_no").toString());

            sc = sc.replace("310052514629", ls_json.get("mdtrt_id").toString());
            sc1 = sc1.replace("310052514629", ls_json.get("mdtrt_id").toString());
            ls_json.put("result",sc);
            ls_json.put("result_cyzt",sc1);
            result_json.add(ls_json);

        }
        return new CommonResult(200, "成功", result_json);
    }


    //冲销门诊住院
    @RequestMapping("/zymzcx")
    public Object mz_cqjs(@RequestBody JSONObject jsonObject){

            YBLogEntity ybLogEntity=new YBLogEntity();
            ybLogEntity.setJylx(jsonObject.getString("jylx"));//交易类型
            ybLogEntity.setStarttime(jsonObject.getString("starttime"));
            ybLogEntity.setEndtime(jsonObject.getString("endtime"));
            ybLogEntity.setYbjgid(jsonObject.getString("ybjgid"));
            ybLogEntity.setParam(jsonObject.getString("param"));

            Object objj=ybService.query_ZYMZCX(ybLogEntity);

        return objj;
    }

    @RequestMapping("/drmzzycx")
    public Object mzzycx_dr(@RequestBody JSONObject jsonObject){
        Object obj=ybService.query_DRZYMZCX(jsonObject);
            return obj;
    }

/*    @RequestMapping("/ypzlmx")
    public void ypzlmx(){
        try {
            ybService.test02("E:\\202108106785348076776592002.txt");
            System.out.println("搞定");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/


//    //医保对账不不和处理数据
//    @RequestMapping("/ybdz")
//    public  void ybdz(String ybjgid,String yblx){
//        ybService.ybdz("","");
//    }
}
