package com.jsg.examples.dao;

import com.jsg.examples.entity.MenulistEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface HomeDao {

    List<MenulistEntity> menulist1();
    List<MenulistEntity> menulist2();
}
