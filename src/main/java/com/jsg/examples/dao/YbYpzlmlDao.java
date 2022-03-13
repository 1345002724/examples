package com.jsg.examples.dao;

import com.jsg.examples.entity.YbYpzlml;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface YbYpzlmlDao {
    int insert(YbYpzlml record);

    int insertSelective(YbYpzlml record);
}