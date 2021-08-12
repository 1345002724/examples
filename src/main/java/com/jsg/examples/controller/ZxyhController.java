package com.jsg.examples.controller;

import com.jsg.examples.entity.CommonResult;
import com.jsg.examples.entity.RybmEntity;
import com.jsg.examples.service.ZxyhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/xtjk")
public class ZxyhController {

    @Autowired
    ZxyhService zxyhService;

    @Autowired
    RedisTemplate redisTemplate;

    //查询在线用户
    @RequestMapping("/zxyh")
    public CommonResult getZxyh() {
        List<RybmEntity> result = zxyhService.getZxyhservice();
        if (result.size() > 0) {
            return new CommonResult(200, "成功", result);
        } else
            return new CommonResult(444, "失败", "获取数据失败");
    }

    //强制退出登录操作
    @RequestMapping("/handleForceLogout")
    public CommonResult handleForceLogout(String token) {
        token = token == null ? "" : token;   //判断token,防止token为null程序报错
        Boolean result = redisTemplate.delete(token);//删除token
        if (result) {
            return new CommonResult(200, "成功", "强退成功");
        } else
            return new CommonResult(444, "失败", "强退失败");
    }
}
