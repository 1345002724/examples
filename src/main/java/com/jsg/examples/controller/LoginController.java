package com.jsg.examples.controller;

import com.jsg.examples.config.constants.BaseConstants;
import com.jsg.examples.dao.RybmDao;
import com.jsg.examples.entity.CommonResult;
import com.jsg.examples.entity.RybmEntity;
import com.jsg.examples.utils.DateTime_util;
import com.jsg.examples.utils.IpAndAddrUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.time.Duration;
import java.util.List;
import java.util.UUID;

@RestController
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    RybmDao rybmDao;

    @Resource
    RedisTemplate<String, Object> redisTemplate;

    @Value("${time_out}")
    private Long time_out; //登录超时时间


    //登录
    @RequestMapping("/login")
    public CommonResult login(String username, String password, HttpServletRequest request) {

        String ip = IpAndAddrUtil.getIp(request);//获取请求ip
        logger.debug("登录IP:" + ip);

        String BrowserName = IpAndAddrUtil.getBrowserName(request);//获取浏览器
        logger.debug("浏览器名称:" + BrowserName);

        String BrowserVersion = IpAndAddrUtil.getBrowserVersion(request);//获取浏览器版本
        logger.debug("浏览器版本:" + BrowserVersion);

        String OsName = IpAndAddrUtil.getOsName(request);//获取操作系统
        logger.debug("登录操作系统:" + OsName);


        List<RybmEntity> result = rybmDao.logindao(username, password);
        if (!result.isEmpty()) {

            //生成token
            String token = BaseConstants.LoginUser + UUID.randomUUID().toString();

            //放入登录ip、操作系统、浏览器名称、会话编号、登录时间
            result.get(0).setIp(ip);
            result.get(0).setBrowserName(BrowserName);
            result.get(0).setBrowserVersion(BrowserVersion);
            result.get(0).setOsName(OsName);
            result.get(0).setLogintime(DateTime_util.getTodayDay());//登录时间
            result.get(0).setToken(token.replaceAll(BaseConstants.LoginUser, "").substring(0, 18));
            result.get(0).setLogintoken(token);

            //将token存redis数据库X分钟
            logger.debug("登录超时(分钟)：" + time_out.toString());
            redisTemplate.opsForValue().set(token, result.get(0), Duration.ofMinutes(time_out));
            return new CommonResult(200, "成功", token);
        } else
            return new CommonResult(444, "用户未登录，请从新登录", null);
    }


    //退出登录
    @RequestMapping("/loginout")
    public CommonResult loginout(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        token = token == null ? "" : token;   //判断token防止程序报错
        Boolean result = redisTemplate.delete(token);//删除token
        if (result) {
            logger.debug("注销成功");
            return new CommonResult(200, "成功", "注销成功");

        } else
            return new CommonResult(444, "失败", "注销失败");
    }

}
