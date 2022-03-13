package com.jsg.examples.dao;

import com.jsg.examples.entity.Menulist;

public interface MenulistDao {
    int insert(Menulist record);

    int insertSelective(Menulist record);
}