package com.jsg.examples.service.impl;

import cn.hutool.extra.pinyin.PinyinUtil;
import com.jsg.examples.dao.RybmDao;
import com.jsg.examples.entity.QueryInfoEntity;
import com.jsg.examples.entity.RybmEntity;
import com.jsg.examples.service.RybmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RybmServiceImpl implements RybmService {

    @Autowired
    RybmDao rybmDao;


    //查询人员信息
    @Override
    public List<RybmEntity> queryRybm(QueryInfoEntity queryInfoEntity) {
        List<RybmEntity> result = rybmDao.queryRybm(queryInfoEntity);
        return result;
    }

    //插入人员信息
    @Override
    public Integer insertrybm(RybmEntity rybmEntity) {
        //生成拼音首字母
        rybmEntity.setPYDM(PinyinUtil.getFirstLetter(rybmEntity.getRYXM(), "").toUpperCase());
        rybmEntity.setQYZT("1"); //设置启用状态默认为1
        Integer result = rybmDao.insertRybm(rybmEntity);
        if (result > 0) {
            return result;
        } else return 0;
    }

    //删除人员信息
    @Override
    public Integer DeleteUserService(String rybm) {
        Integer result=rybmDao.DeleteUser(rybm);
        return result;
    }
}
