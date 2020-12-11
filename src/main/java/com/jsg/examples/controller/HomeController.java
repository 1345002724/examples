package com.jsg.examples.controller;

import com.jsg.examples.entity.CommonResult;
import com.jsg.examples.entity.MenulistEntity;
import com.jsg.examples.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    HomeService homeService;
    @RequestMapping("/menulist")
    public CommonResult menulist(){
        List<MenulistEntity> result=homeService.MenulistService();
        if(result.size()>0) {
            return new CommonResult(200, "成功", result);
        }else
            return new CommonResult(444, "失败", null);
    }
}
