package com.jsg.examples.controller;

import com.jsg.examples.entity.CommonResult;
import com.jsg.examples.entity.MenulistEntity;
import com.jsg.examples.service.HomeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@Api("homeController")
@RestController
@RequestMapping("/home")
public class HomeController {


    @Autowired
    HomeService homeService;

   @ApiOperation(value = "干嘛的")
    @RequestMapping(value = "/menulist",method = RequestMethod.GET)
    public CommonResult menulist() {
        List<MenulistEntity> result = homeService.MenulistService();
        if (result.size() > 0) {
            return new CommonResult(200, "成功", result);
        } else
            return new CommonResult(444, "失败", null);
    }
}
