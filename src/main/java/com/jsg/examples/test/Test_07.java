package com.jsg.examples.test;

import com.jsg.examples.entity.CommonResult;
import com.jsg.examples.spring.entity.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test_07 {
    public static void main(String[] args) {
        List<User> list=new ArrayList<>();
        Map<String,Object> map=new HashMap<>();
        map.put("aqq",new CommonResult<>());

    }
}
