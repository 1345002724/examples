package com.jsg.examples.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jsg.examples.dao.YbDao;
import com.jsg.examples.entity.YBLogEntity;
import com.jsg.examples.service.YBService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YbServiceImpl implements YBService {

    @Autowired
    YbDao ybDao;

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

    @Override
    public Object query_DRZYMZCX(YBLogEntity ybLogEntity) {


        return null;
    }
}
