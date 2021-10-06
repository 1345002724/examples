package com.jsg.examples.config.Interceptor;


import com.alibaba.fastjson.JSONObject;
import com.jsg.examples.constants.BaseConstants;
import com.jsg.examples.entity.CommonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.time.Duration;
import java.util.concurrent.TimeUnit;


@Component
public class LoginInterceptor implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    @Resource
    RedisTemplate<String, Object> redisTemplate;

    @Value("${time_out}")
    private Long time_out; //登录超时设置

    //处理器方法执行前调用
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //进行登录校验

/*        //一、判断是否重复提交
        String requesturl= request.getHeader("Authorization")+request.getRequestURI();
        logger.debug("访问路径:"+requesturl);
        requesturl=requesturl==null?"":requesturl;
        long urltime=redisTemplate.getExpire(requesturl);
        if(urltime>0){
            logger.info("重复登录");
            return false;
        } else redisTemplate.opsForValue().set(requesturl,0, 1,TimeUnit.SECONDS);*/


        //判断是否登录状态
        String token = request.getHeader("Authorization");
        token = token == null ? "" : token;   //判断token防止程序报错
        // Object result= redisTemplate.opsForValue().get(token);
        Long expire = redisTemplate.getExpire(token);//查询token在Redis中的时间

        expire= Long.valueOf(2);//临时屏蔽登录验证

        if (expire > 0) {  //是登录状态
            //重置登录时间
            redisTemplate.expire(token, time_out, TimeUnit.MINUTES);
            return true;
        } else {
            logger.debug("登录失败,拦截器处抛出");
            response.setContentType("json/text;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.write(JSONObject.toJSONString(new CommonResult(BaseConstants.CODE_LOGIN, "错误", "用户未登录")));
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

