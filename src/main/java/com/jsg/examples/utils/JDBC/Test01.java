package com.jsg.examples.utils.JDBC;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test01 {
    public static void main(String[] args) {
        Map map1=new HashMap();
        String s = "";
        List<Map<String,Object>> list=new ArrayList<>();
        list= DBUtils.Mysql("select * from username");
        for(int i=0;i<list.size();i++){
           // Map<String,Object> map=new HashMap<>();
/*            System.out.println(list.get(i).get("id"));
            System.out.println(list.get(i).get("name"));
            System.out.println(list.get(i).get("password"));
            System.out.println(list.get(i).get("sfzh"));
            System.out.println(list.get(i).get("sjhm"));*/
            String ls=list.get(i).get("id")+" "+list.get(i).get("name");
            s=s+ls+"\t";
            for(String key:list.get(i).keySet()){
              //  System.out.println("key值为:"+key+"--values值为:"+list.get(i).get(key));

            }
        }

        System.out.println(s);
        /**
         *
         * @author :liu
         * @date :2021-11-28
         * @description:获取一个map集合
         *
         */
        Map<String,Object> map=new HashMap<>();
        String sql="select * from username";
        map=DBUtils.Mysql(sql).get(0);
        //System.out.println(map.toString());

    }
}
