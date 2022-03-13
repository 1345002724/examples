package com.jsg.examples.dao;

import com.jsg.examples.entity.YbBddz;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface YbBddzDao {
    int insert(YbBddz record);

    int insertSelective(YbBddz record);
    List<Map<String,Object>> ybquery();
}