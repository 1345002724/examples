package com.jsg.examples.dao;

import com.jsg.examples.entity.QueryInfoEntity;
import com.jsg.examples.entity.RybmEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RybmDao {
     //查询人员信息
     List<RybmEntity> queryRybm(QueryInfoEntity queryInfoEntity);
     //登录
     List<RybmEntity> logindao(@Param("username") String username,@Param("password") String password);

     Integer insertRybm(RybmEntity rybmEntity);

     //修改人员状态
     int updateRybm(@Param("rybm") String rybm,@Param("qyzt") String qyzt);

     //删除人员

     Integer DeleteUser(@Param("rybm") String rybm);
}
