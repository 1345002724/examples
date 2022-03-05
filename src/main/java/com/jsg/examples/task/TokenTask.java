package com.jsg.examples.task;


import com.alibaba.fastjson.JSONObject;
import com.jsg.examples.entity.CommonResult;
import com.jsg.examples.utils.ReadFile;
import com.sun.media.jfxmedia.logging.Logger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

import static com.jsg.examples.utils.Http_Yb_Test.doPost_xxcf;

@Slf4j
@Configuration
public class TokenTask {

    public String token;
    public String cookie;
    private ScheduledExecutorService executor = null;

    @PostConstruct
    public void init() {
        start();
    }

    /*开启循环方法*/
    public void start() {
        if (executor == null) {
            executor = Executors.newSingleThreadScheduledExecutor();
            ScheduledFuture<?> scheduledFuture = executor.scheduleAtFixedRate(new Runnable() {
                @Override
                public void run() {
                    log.info("定时器在定时执行任务");
                }
            }, 0, 4, TimeUnit.MINUTES);
        }
    }


    /*关闭循环定时器*/
    public void stop() {
        if (executor != null) {
            executor.shutdown();
            executor = null;
        }
    }

    /*查询定时器状态*/
    public boolean state() {
        return executor != null;
    }
}
