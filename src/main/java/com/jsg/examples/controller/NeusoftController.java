package com.jsg.examples.controller;

import com.jsg.examples.config.utils.InvocationFactory;
import com.jsg.examples.config.utils.InvocationResult;
import com.jsg.examples.entity.CommonResult;
import com.jsg.examples.service.NeusoftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RequestMapping("/Neusoft")
@RestController
public class NeusoftController {

    @Autowired
    NeusoftService neusoftService;

    @RequestMapping("/trade5303")
    public  CommonResult trade5303(HttpServletRequest request , HttpServletResponse response){
        //返回结果
        CommonResult result= InvocationResult.newInstance();
        //请求参数
        Map<String,Object> resParam=InvocationFactory.getInvocation(request);
        neusoftService.trade5303(resParam,result);
        return result;

    }
}
