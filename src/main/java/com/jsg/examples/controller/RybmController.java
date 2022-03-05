package com.jsg.examples.controller;

import com.jsg.examples.constants.BaseConstants;
import com.jsg.examples.dao.RybmDao;
import com.jsg.examples.entity.CommonResult;
import com.jsg.examples.entity.QueryInfoEntity;
import com.jsg.examples.entity.RybmEntity;
import com.jsg.examples.service.RybmService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequestMapping("/user")
@RestController
public class RybmController<T> {
    private static final Logger logger = LoggerFactory.getLogger(RybmController.class);


    @Autowired
    RybmService rybmService;
    @Autowired
    RybmDao rybmDao;

    //查询人员信息
    @RequestMapping(value = "/queryrybm", consumes = "application/json")
    public CommonResult queryrybm(@RequestBody QueryInfoEntity queryInfoEntity) {

        logger.debug(queryInfoEntity.toString());
        List<RybmEntity> result = rybmService.queryRybm(queryInfoEntity);
        //if(result!=null){  用于判断单个
        if (!result.isEmpty()) {
            return new CommonResult(200, "成功", result);
        } else {
            return (new CommonResult(444, "失败", null));
        }
    }

    //修改人员状态
    @RequestMapping("/updateRybm")
    public CommonResult updateRybm(String rybm,String qyzt) {
        if (rybm != null) {

            Integer num = rybmDao.updateRybm(rybm, qyzt);
            if (num > 0)
                return new CommonResult(200, "成功", "更新成功"+num);
            else
                return new CommonResult(200, "失败", "更新数据失败");
        } else
            return new CommonResult(200, "失败", "人员编码不能为空");
    }


    //新增人员信息
    @RequestMapping("/insertrybm")
    public CommonResult insertrybm(@RequestBody RybmEntity rybmEntity) {
        logger.debug(rybmEntity.toString());
        Integer result = rybmService.insertrybm(rybmEntity);
        if (result > 0) {
            return new CommonResult(200, BaseConstants.MESSAGE_SUCCESS, result);
        } else {
            return (new CommonResult(200, "失败", null));
        }
    }

    @RequestMapping("/DeleteUser")
    public CommonResult DeleteUser(String rybm){

        if(rybm!=null) {
            Integer result=rybmService.DeleteUserService(rybm);
            if(result>0){
                return new CommonResult(200, "成功", "成功");
            } else
                return new CommonResult(200, "失败", null);
        } else
            logger.debug("人员编码不能为空");
            return new CommonResult(200, "人员编码不能为空", null);
    }

}
