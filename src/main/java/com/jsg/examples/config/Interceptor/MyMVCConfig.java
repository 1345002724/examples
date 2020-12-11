package com.jsg.examples.config.Interceptor;


import com.jsg.examples.config.Interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMVCConfig implements WebMvcConfigurer {



    //他是用来添加拦截器的
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //添加拦截器
       // InterceptorRegistration interceptorRegistration = registry.addInterceptor(new LoginInterceptor());
        /*********************springboot的拦截器中注入redisTemplate为null的解决办法*********************/
        InterceptorRegistration interceptorRegistration = registry.addInterceptor(getloginInterceptor());
        //添加拦截映射规则，哪些拦截，哪些不拦截
        //先拦截所有
        interceptorRegistration.addPathPatterns("/**");
        //排除不拦截的
        interceptorRegistration.excludePathPatterns("/login","/login.html","*.js","*.css");
    }


    /*********************springboot的拦截器中注入redisTemplate为null的解决办法*********************/
    @Bean
     public LoginInterceptor getloginInterceptor(){
        return new LoginInterceptor();
    }

}




