package com.jsg.examples.dao;

import com.jsg.examples.entity.YbJymx;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface YbJymxDao {
    int deleteByPrimaryKey(Integer id);

    int insert(YbJymx record);

    int insertSelective(YbJymx record);

    YbJymx selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(YbJymx record);

    int updateByPrimaryKey(YbJymx record);
}