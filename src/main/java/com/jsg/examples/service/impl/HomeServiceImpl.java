package com.jsg.examples.service.impl;

import com.jsg.examples.dao.HomeDao;
import com.jsg.examples.entity.MenulistEntity;
import com.jsg.examples.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class HomeServiceImpl implements HomeService {

    @Autowired
    HomeDao homeDao;

    @Override
    public List<MenulistEntity> MenulistService() {


        List<MenulistEntity> res1=homeDao.menulist1();
        List<MenulistEntity> res2=homeDao.menulist2();


        for (int i=0;i<res1.size();i++){

            for(int j=0;j<res2.size();j++){

                if(res1.get(i).getMkbm1().equals(res2.get(j).getMkbm1())){

                    res1.get(i).getChildren().add(res2.get(j));
                    }
                }
            }


        return res1;
    }
}
