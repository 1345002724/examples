package com.jsg.examples.service;

import com.jsg.examples.entity.QueryInfoEntity;
import com.jsg.examples.entity.RybmEntity;

import java.util.List;

public interface RybmService {

    List<RybmEntity> queryRybm(QueryInfoEntity queryInfoEntity);
    Integer insertrybm(RybmEntity rybmEntity);

    Integer DeleteUserService(String rybm);

}
