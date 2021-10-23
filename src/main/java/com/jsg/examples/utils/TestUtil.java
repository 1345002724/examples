/*
package com.jsg.examples.utils;

import com.google.common.collect.Lists;
import com.jsg.examples.config.Interceptor.LoginInterceptor;
import org.apache.catalina.connector.Request;
import org.springframework.web.servlet.HandlerInterceptor;

import sun.rmi.runtime.Log;

import java.util.List;

public class TestUtil {
    static class Request{}

    static class MVC{
        List<HandlerInterceptor> handlerInterceptorList = Lists.newArrayList();


        void request(Request request){
            //eekkkdfsdsd
            if (!handlerInterceptorList.isEmpty()) {
                for (HandlerInterceptor interceptor : handlerInterceptorList) {
                    interceptor.preHandle()
                            ///
 //调用controller

                    //
                   interceptor.postHandle();
                            ///

                }
            }

            if (!handlerInterceptorList.isEmpty()) {

            }

        }



        void addIntercepter(HandlerInterceptor interceptor) {
            handlerInterceptorList.add(interceptor);
        }
    }


    public static void main(String[] args) {
        MVC mvc = new MVC();

        LoginInterceptor loginInterceptor = new LoginInterceptor();
        mvc.addIntercepter(loginInterceptor);


        mvc.request(new Request());


    }
}
*/
