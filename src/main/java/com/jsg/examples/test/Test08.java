package com.jsg.examples.test;

import java.util.*;

public class Test08 {

    public static void main(String[] args) {
        List<Map<String,String>> list=new ArrayList<>();
        Map<String,String> map1=new HashMap<>() ;
        Map<String,String> map2=new HashMap<>() ;
        map1.put("NAME","张三");
        map1.put("AGE","22");
        map1.put("SSHH","晓不得");
        map2.put("NAME","感冒病");
        map2.put("AGE","33");
        map2.put("SSDD","晓不得");
        list.add(map1);
        list.add(map2);

        List<Map<String,String>> list1=new ArrayList<>();
        for(int i=0;i<list.size();i++) {
            Map<String,String> map=new HashMap<>() ;
            for (Map.Entry<String, String> entry : list.get(i).entrySet()) {
                map.put(entry.getKey().toLowerCase(),entry.getValue());
            }
            list1.add(map);
        }
        System.out.println(list1.toString());

/*        List<Map<String,String>> list1=new ArrayList<>();

        for(int i=0;i<list.size();i++){
            Map<String,String> map=new HashMap<>() ;
            for(String set:list.get(i).keySet()){
               // list.get(i).put(set.toLowerCase(),list.get(i).get(set));//放入新的
               // list.get(i).remove(set);//移除旧的
                map.put(set.toLowerCase(),list.get(i).get(set));//放入新的
            }
            list1.add(map);
        }
        System.out.println(list1.toString());*/
    }
}
