package com.jsg.examples.controller;
import com.jsg.examples.dao.RybmDao;
import com.jsg.examples.entity.CommonResult;
import com.jsg.examples.entity.RybmEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.time.Duration;
import java.util.List;
import java.util.UUID;

@RestController
public class LoginController {

    @Autowired
    RybmDao rybmDao;

    @Resource
    RedisTemplate<String,Object> redisTemplate;




    @RequestMapping("/login")
    public CommonResult login(String username,String password){
        List<RybmEntity> result=rybmDao.logindao(username,password);
        if(!result.isEmpty()){
            //生成token
            String token= UUID.randomUUID().toString();
            //将token存redis数据库20分钟
            redisTemplate.opsForValue().set(token,result.get(0),Duration.ofMinutes(20));
            return new CommonResult(200, "成功", token);
        }else
            return new CommonResult(444, "用户未登录，请从新登录", null);
    }



/*    *//*测试登录验证*//*
    @RequestMapping("/logintest")
    public CommonResult logintest(HttpServletRequest request){
        //获取header中的参数

       String token= request.getHeader("token");
       Object result= redisTemplate.opsForValue().get(token);
       if(result !=null){
           return new CommonResult(200,"成功",result);
       } else
           return new CommonResult(444, "失败", null);

    }*/

}
