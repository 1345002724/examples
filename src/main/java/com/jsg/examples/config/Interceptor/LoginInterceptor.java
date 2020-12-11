package com.jsg.examples.config.Interceptor;


import com.alibaba.fastjson.JSONObject;
import com.jsg.examples.entity.CommonResult;
import javafx.print.Printer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;


@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Resource
    RedisTemplate<String,Object> redisTemplate;
    //处理器方法执行前调用
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //进行登录校验


        String token= request.getHeader("Authorization");
        token=token==null?"":token;   //判断token防止程序报错
       // Object result= redisTemplate.opsForValue().get(token);
        Long expire=redisTemplate.getExpire(token);//查询token在Redis中的时间
        if(expire>0){
            return true;
        }else{
            //未登录，返回登录界面
           // request.setAttribute("msg","您未登录，请先进行登录！！！");
            //request.getRequestDispatcher("/login").forward(request,response);
            System.out.println("登录失败");

            response.setContentType("json/text;charset=utf-8");
            PrintWriter out=response.getWriter();
            out.write(JSONObject.toJSONString(new CommonResult(444, "错误", "用户未登录")));
            return false;
        }
    }

    //处理器方法执行后调用
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    //请求处理完毕后，响应视图前
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}

