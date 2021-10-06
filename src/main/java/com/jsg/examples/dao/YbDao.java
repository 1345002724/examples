package com.jsg.examples.dao;

import com.jsg.examples.entity.MenulistEntity;
import com.jsg.examples.entity.YBLogEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface YbDao {
    List<YBLogEntity> YbLogEntity(YBLogEntity ybLogEntity);
}
