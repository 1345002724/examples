package com.jsg.examples.service.impl;

import com.jsg.examples.config.constants.BaseConstants;
import com.jsg.examples.entity.RybmEntity;
import com.jsg.examples.service.ZxyhService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class ZxyhServiceImpl implements ZxyhService {

    private static final Logger logger = LoggerFactory.getLogger(ZxyhServiceImpl.class);

    @Resource
    private RedisTemplate redisTemplate;

    //查询在线用户数量
    @Override
    public List<RybmEntity> getZxyhservice() {
        Collection<String> keys = redisTemplate.keys(BaseConstants.LoginUser + "*");
        List<RybmEntity> userOnlineList = new ArrayList<RybmEntity>();

        for (String key : keys) {
            RybmEntity user = (RybmEntity) redisTemplate.opsForValue().get(key);
            logger.debug(user.toString());
            userOnlineList.add(user);
        }
        return userOnlineList;
    }
}
