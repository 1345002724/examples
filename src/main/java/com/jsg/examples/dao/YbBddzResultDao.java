package com.jsg.examples.dao;

import com.jsg.examples.entity.YbBddz;
import com.jsg.examples.entity.YbBddzResult;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface YbBddzResultDao {
    int insert(YbBddzResult record);

    int insertSelective(YbBddzResult record);

    //职工异常数据
    List<YbBddzResult> yb_ycsj_zg(@Param("ybjgid") String ybjgid);

    //居民异常数据
    List<YbBddzResult> yb_ycsj_jm(@Param("ybjgid") String ybjgid);
}