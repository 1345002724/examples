package com.jsg.examples.dao;

import com.jsg.examples.entity.RybmEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RybmDao {
     List<RybmEntity> queryRybm(@Param("str") String str);
     List<RybmEntity> logindao(@Param("username") String username,@Param("password") String password);
     int insertRybm(RybmEntity rybmEntity);
}
