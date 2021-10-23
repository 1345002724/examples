package com.jsg.examples.service.impl;

import cn.hutool.core.io.IoUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jsg.examples.dao.YbDao;
import com.jsg.examples.dao.YbYpzlmlDao;
import com.jsg.examples.entity.CommonResult;
import com.jsg.examples.entity.YBLogEntity;
import com.jsg.examples.entity.YbYpzlml;
import com.jsg.examples.service.YBService;

import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static com.jsg.examples.utils.Http_Yb_Test.doPost_xxcf;

@Service
public class YbServiceImpl implements YBService {

    @Autowired
    YbDao ybDao;

    @Autowired
    YbYpzlmlDao ybYpzlmlDao;

    @Override
    public Object query_ZYMZCX(YBLogEntity ybLogEntity) {

        String fixmedins_code=ybLogEntity.getYbjgid(); //医保机构id
        String jylx=ybLogEntity.getJylx();//交易类型

        List<YBLogEntity> ls_temp=ybDao.YbLogEntity(ybLogEntity);
        JSONArray jsonArray=new JSONArray();

        for(int i=0;i<ls_temp.size();i++){

           JSONObject jsonObject= JSONObject.parseObject(ls_temp.get(i).getOutstr());
           if(!jsonObject.get("infcode").equals("0")){
               continue;
           }
            JSONObject jsonObject1=jsonObject.getJSONObject("output").getJSONObject("setlinfo");
            String psn_name=jsonObject1.get("psn_name").toString();
            String mdtrt_id=jsonObject1.get("mdtrt_id").toString();
            String setl_id=jsonObject1.get("setl_id").toString();
            String psn_no=jsonObject1.get("psn_no").toString();
            String certno=jsonObject1.get("certno").toString(); //身份证号码
            String medfee_sumamt=jsonObject1.get("medfee_sumamt").toString();//总金额
            if (certno.contains(ybLogEntity.getParam())||psn_name.contains(ybLogEntity.getParam())){

                JSONObject jsonObject2=new JSONObject();
                jsonObject2.put("psn_name",psn_name);
                jsonObject2.put("mdtrt_id",mdtrt_id);
                jsonObject2.put("setl_id",setl_id);
                jsonObject2.put("psn_no",psn_no);
                jsonObject2.put("medfee_sumamt",medfee_sumamt);
                jsonObject2.put("certno",certno);
                jsonObject2.put("jylx",jylx);

                if(jylx.equals("2207")) {
                    String sc_mz = String.valueOf(new StringBuffer("               {\n" +
                            "                    \"infno\": \"2208\",\n" +
                            "                        \"msgid\": \"H50023301115210627101410\",\n" +
                            "                        \"insuplc_admdvs\": \"500153\",\n" +
                            "                        \"mdtrtarea_admvs\": \"500153\",\n" +
                            "                        \"recer_sys_code\": \"YBXT\",\n" +
                            "                        \"dev_no\": \"\",\n" +
                            "                        \"dev_safe_info\": \"\",\n" +
                            "                        \"cainfo\": \"\",\n" +
                            "                        \"infver\": \"V1.0\",\n" +
                            "                        \"opter_type\": \"1\",\n" +
                            "                        \"opter\": \"5012\",\n" +
                            "                        \"opter_name\": \"徐长卿\",\n" +
                            "                        \"inf_time\": \"2021-06-21\",\n" +
                            "                        \"fixmedins_code\": \"H50023301115\",\n" +
                            "                        \"fixmedins_name\": \"冲销专用卫生院\",\n" +
                            "                        \"sign_no\": \"\",\n" +
                            "                        \"input\": {\n" +
                            "                    \"data\": {\n" +
                            "                        \"mdtrt_id\": \"310053693626\",\n" +
                            "                                \"psn_no\": \"JM2028043485\",\n" +
                            "                                \"setl_id\": \"300037886638\"\n" +
                            "                    }\n" +
                            "                }\n" +
                            "                }"));


                    sc_mz = sc_mz.replace("310053693626", mdtrt_id);
                    sc_mz = sc_mz.replace("JM2028043485", psn_no);
                    sc_mz = sc_mz.replace("300037886638", setl_id);
                    sc_mz = sc_mz.replace("H50023301115", fixmedins_code);
                    jsonObject2.put("cxresult", sc_mz);
                    jsonArray.add(jsonObject2);
                }

                //住院
                if(jylx.equals("2304")) {
                    String sc_mz = String.valueOf(new StringBuffer("{\n" +
                            "  \"infno\": \"2305\",\n" +
                            "  \"msgid\": \"H50023305447210627101410\",\n" +
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
                            "  \"inf_time\": \"2021-06-28 17:09:58\",\n" +
                            "  \"fixmedins_code\": \"H50023305447\",\n" +
                            "  \"fixmedins_name\": \"冲销专用卫生院\",\n" +
                            "  \"sign_no\": \"\",\n" +
                            "  \"input\": {\n" +
                            "    \"data\": {\n" +
                            "      \"mdtrt_id\": \"310053690712\",\n" +
                            "      \"setl_id\": \"300037866869\",\n" +
                            "      \"psn_no\": \"JM2027983534\"\n" +
                            "    }\n" +
                            "  }\n" +
                            "}"));


                    sc_mz = sc_mz.replace("310053690712", mdtrt_id);
                    sc_mz = sc_mz.replace("JM2027983534", psn_no);
                    sc_mz = sc_mz.replace("300037866869", setl_id);
                    sc_mz = sc_mz.replace("H50023305447", fixmedins_code);
                    jsonObject2.put("cxresult", sc_mz);
                    jsonArray.add(jsonObject2);
                }



            }

        } return jsonArray;

    }

    //查询医保身份证信息(获取)
    @Override
    public CommonResult query_DRZYMZCX(JSONObject jsonObject) {

        String sfzh=jsonObject.getString("sfzh");
        String cookie=jsonObject.getString("cookie");
        String token=jsonObject.getString("token");
        String insutype=jsonObject.getString("insutype"); //类型职工还是居民职工传310，居民传390


        //tomcat容器默认采用了iso-8859-1的编码方法.此处将form_data里面的frontUrl编码
        String value="http://10.123.46.1/hds/N1702.html#/N170204?_modulePartId_=17-2-4";
        try {
            value= new String(value.getBytes("iso-8859-1"),"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Map<String, String> map=new HashMap();
        map.put("psnNo","");
        map.put("certno",sfzh);
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


        /*判断获取到数据没有，如果没有返回报错*/

        if(!(JSONObject.parseObject(result).get("code")+"").equals("0")){
            return  new CommonResult(400,"失败",result);
        }

        //获取人员psn_no
        String psnNo=JSONObject.parseObject(result).getJSONObject("data").
                getJSONArray("list").getJSONObject(0).getString("psnNo");
        System.out.println("第一段结束，人员编码为"+psnNo);

        //线程休息1秒执行第二段
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("第二段开始");
        Map<String, String> map1=new HashMap();
        map1.put("insutype",insutype);
        map1.put("psnNo",psnNo);
        map1.put("_modulePartId_","17-2-4");
        map1.put("frontUrl",value);


        String  data1="";
        for(Map.Entry key : map1.entrySet()){
            if(data1.length()>0) data1+="&";
            data1 += key.getKey()+"="+key.getValue();
        }

        String url1="http://10.123.46.1/hds/back/web/psnSetlPrint/querySetlPageInfoPayLoc";
        String result1=doPost_xxcf(url1,  data1,cookie,token);

        if(!(JSONObject.parseObject(result1).get("code")+"").equals("0")){
            return  new CommonResult(400,"失败",result1);
        }

        JSONArray jsr1=JSONObject.parseObject(result1).getJSONObject("data").getJSONObject("pageBean").getJSONArray("data");


        JSONArray jsr_result=new JSONArray();

        for(int i=0;i<jsr1.size();i++){

            JSONObject json=new JSONObject();

            String msgid=jsr1.getJSONObject(i).getString("medinsSetlId");
            String fixmedins_code=jsr1.getJSONObject(i).getString("fixmedinsCode");
            String fixmedins_name=jsr1.getJSONObject(i).getString("fixmedinsName");
            String mdtrt_id=jsr1.getJSONObject(i).getString("mdtrtId");
            String psn_no=jsr1.getJSONObject(i).getString("psnNo");
            String setl_id=jsr1.getJSONObject(i).getString("setlId");
            String opter=jsr1.getJSONObject(i).getString("opterId");
            opter = opter == null ? "" : opter;
            String opter_name=jsr1.getJSONObject(i).getString("opterName");
            opter_name = opter_name == null ? "" : opter_name;
            String inf_time=jsr1.getJSONObject(i).getString("setlTime");
            String medType=jsr1.getJSONObject(i).getString("medType");//医疗类别（11位门诊，21为住院）;

            if(!medType.equals("21")){
                json.put("lx","门诊");
            } else  json.put("lx","住院");

            json.put("setlTime",jsr1.getJSONObject(i).getString("setlTime"));//结算时间
            json.put("msgid",msgid);
            json.put("fixmedins_code",fixmedins_code);
            json.put("fixmedins_name",fixmedins_name);
            json.put("mdtrt_id",mdtrt_id);
            json.put("psn_no",psn_no);
            json.put("psn_name",jsr1.getJSONObject(i).getString("psnName"));
            json.put("setl_id",setl_id);
            json.put("ylzfy",jsr1.getJSONObject(i).getString("medfeeSumamt")); /*医疗总费用*/
            json.put("qzfje",jsr1.getJSONObject(i).getString("fulamtOwnpayAmt")); /*全自费费用*/


            if(!medType.equals("21")){
                String ls_sc= String.valueOf(new StringBuffer("{\n" +
                        "  \"infno\": \"2208\",\n" +
                        "  \"msgid\": \"H50023301436210627101410\",\n" +
                        "  \"insuplc_admdvs\": \"500153\",\n" +
                        "  \"mdtrtarea_admvs\": \"500153\",\n" +
                        "  \"recer_sys_code\": \"YBXT\",\n" +
                        "  \"dev_no\": \"\",\n" +
                        "  \"dev_safe_info\": \"\",\n" +
                        "  \"cainfo\": \"\",\n" +
                        "  \"infver\": \"V1.0\",\n" +
                        "  \"opter_type\": \"1\",\n" +
                        "  \"opter\": \"415012\",\n" +
                        "  \"opter_name\": \"徐长卿\",\n" +
                        "  \"inf_time\": \"2021-06-21\",\n" +
                        "  \"fixmedins_code\": \"H500233014362\",\n" +
                        "  \"fixmedins_name\": \"重庆市江北区寸滩街道茅溪社区卫生服务站\",\n" +
                        "  \"sign_no\": \"\",\n" +
                        "  \"input\": {\n" +
                        "    \"data\": {\n" +
                        "      \"mdtrt_id\": \"310059106671\",\n" +
                        "      \"psn_no\": \"JM2035806076\",\n" +
                        "      \"setl_id\": \"300041773692\"\n" +
                        "    }\n" +
                        "  }\n" +
                        "}"));

                ls_sc = ls_sc.replace("H50023301436210627101410", msgid);
                ls_sc = ls_sc.replace("415012", opter);
                ls_sc = ls_sc.replace("徐长卿", opter_name);
                ls_sc = ls_sc.replace("2021-06-21", inf_time);
                ls_sc = ls_sc.replace("H500233014362", fixmedins_code);
                ls_sc = ls_sc.replace("重庆市江北区寸滩街道茅溪社区卫生服务站", fixmedins_name);
                ls_sc = ls_sc.replace("310059106671", mdtrt_id);
                ls_sc = ls_sc.replace("JM2035806076", psn_no);
                ls_sc = ls_sc.replace("300041773692", setl_id);
                 ls_sc = StringEscapeUtils.unescapeJava(ls_sc);//去掉转义字符
                json.put("ls_sc",ls_sc);
            }


            //住院
            if(medType.equals("21")){
                String ls_sc= String.valueOf(new StringBuffer("{\n" +
                        "  \"infno\": \"2305\",\n" +
                        "  \"msgid\": \"H50023301436210627101410\",\n" +
                        "  \"insuplc_admdvs\": \"500153\",\n" +
                        "  \"mdtrtarea_admvs\": \"500153\",\n" +
                        "  \"recer_sys_code\": \"YBXT\",\n" +
                        "  \"dev_no\": \"\",\n" +
                        "  \"dev_safe_info\": \"\",\n" +
                        "  \"cainfo\": \"\",\n" +
                        "  \"infver\": \"V1.0\",\n" +
                        "  \"opter_type\": \"1\",\n" +
                        "  \"opter\": \"415012\",\n" +
                        "  \"opter_name\": \"徐长卿\",\n" +
                        "  \"inf_time\": \"2021-06-21\",\n" +
                        "  \"fixmedins_code\": \"H500233014362\",\n" +
                        "  \"fixmedins_name\": \"重庆市江北区寸滩街道茅溪社区卫生服务站\",\n" +
                        "  \"sign_no\": \"\",\n" +
                        "  \"input\": {\n" +
                        "    \"data\": {\n" +
                        "      \"mdtrt_id\": \"310059106671\",\n" +
                        "      \"psn_no\": \"JM2035806076\",\n" +
                        "      \"setl_id\": \"300041773692\"\n" +
                        "    }\n" +
                        "  }\n" +
                        "}"));

                ls_sc = ls_sc.replace("H50023301436210627101410", msgid);
                ls_sc = ls_sc.replace("415012", opter);
                ls_sc = ls_sc.replace("徐长卿", opter_name);
                ls_sc = ls_sc.replace("2021-06-21", inf_time);
                ls_sc = ls_sc.replace("H500233014362", fixmedins_code);
                ls_sc = ls_sc.replace("重庆市江北区寸滩街道茅溪社区卫生服务站", fixmedins_name);
                ls_sc = ls_sc.replace("310059106671", mdtrt_id);
                ls_sc = ls_sc.replace("JM2035806076", psn_no);
                ls_sc = ls_sc.replace("300041773692", setl_id);
                ls_sc = StringEscapeUtils.unescapeJava(ls_sc);//去掉转义字符
                json.put("ls_sc",ls_sc);
            }

            jsr_result.add(json);

        }
        return new CommonResult(200, "成功", jsr_result);
    }

    /*药品对码*/
    @Override
    public  void test02(String str) throws IOException {
        File file=new File(str);
        FileReader stream = new FileReader(file);
        BufferedReader reader = new BufferedReader(stream);
        String s = reader.readLine();
        int ind =0;
        while (s!=null){
            Map<String, Object> m = new LinkedHashMap<>();
         String[] s1 = s.split("\t");
        YbYpzlml ypzlml=new YbYpzlml();

                ypzlml.setBrxz(BigDecimal.valueOf(2));
                ypzlml.setTcqbm("市医保");
                ypzlml.setYbbm("0");
                ypzlml.setTyzwmc(s1[7]);
                ypzlml.setSpmc(s1[3]);
                ypzlml.setTyywmc(s1[6]);
                ypzlml.setSfdl("药品");
                ypzlml.setSfxl(s1[9]);
                ypzlml.setSfxmdj(s1[11]);
                ypzlml.setJx(s1[9]);
                ypzlml.setGg(s1[13]);
                ypzlml.setSccj(s1[53]);
                ypzlml.setTybz(s1[78]);
                ypzlml.setGjbm(s1[0]);
                ypzlml.setPzwh(s1[61]);

               // System.out.println("开始写入数据");
                ybYpzlmlDao.insertSelective(ypzlml);
               // System.out.println(ypzlml.toString());
                s = reader.readLine();
            }


    }





/*诊疗*/
    public  void test03(String str) throws IOException {
        File file=new File(str);
        FileReader stream = new FileReader(file);
        BufferedReader reader = new BufferedReader(stream);
        String s = reader.readLine();
        int ind =0;
        while (s!=null){
            Map<String, Object> m = new LinkedHashMap<>();
            String[] s1 = s.split("\t");
            YbYpzlml ypzlml=new YbYpzlml();

            ypzlml.setBrxz(BigDecimal.valueOf(2));
            ypzlml.setTcqbm("市医保");
            ypzlml.setYbbm("0");
            ypzlml.setTyzwmc(s1[9]);
          //  ypzlml.setSpmc(s1[9]);
          //  ypzlml.setTyywmc(s1[6]);
            ypzlml.setSfdl("诊疗");
            ypzlml.setSfxl(s1[8]);
            ypzlml.setSfxmdj(s1[1]);
          //  ypzlml.setJx(s1[9]);
         //   ypzlml.setGg(s1[13]);
            ypzlml.setSccj(s1[53]);
            ypzlml.setTybz(s1[78]);
            ypzlml.setGjbm(s1[0]);
            ypzlml.setPzwh(s1[61]);

            // System.out.println("开始写入数据");
            ybYpzlmlDao.insertSelective(ypzlml);
            // System.out.println(ypzlml.toString());
            s = reader.readLine();
        }


    }




    public static void main(String[] args) {
        YbServiceImpl ex=new YbServiceImpl();
        String path="E:\\202108106785348076776592002.txt";
        try {
            ex.test02(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
