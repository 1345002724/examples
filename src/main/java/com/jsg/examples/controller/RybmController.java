package com.jsg.examples.controller;

import com.jsg.examples.constants.BaseConstants;
import com.jsg.examples.dao.RybmDao;
import com.jsg.examples.entity.CommonResult;
import com.jsg.examples.entity.RybmEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequestMapping("/examples")
@RestController
public class RybmController<T> {

    @Autowired
    RybmDao rybmDao;

    //查询人员信息
    @RequestMapping("/queryrybm")
    public CommonResult queryrybm(String str){

        List<RybmEntity> result=rybmDao.queryRybm(str);
        //if(result!=null){  用于判断单个
        if(!result.isEmpty()){
            /*
            返回json串写法
            return JSONObject.toJSONString(new CommonResult(200, "成功", result));
            */
            return new CommonResult(200, "成功", result);
        }
        else {
            return (new CommonResult(200, "失败", null));
        }
    }


    //插入人员信息
    @RequestMapping("/insertrybm")
    public CommonResult insertrybm(@RequestBody RybmEntity rybmEntity){
        Integer result=rybmDao.insertRybm(rybmEntity);
        if(result>0){
            return new CommonResult(200, BaseConstants.MESSAGE_SUCCESS, result);
        }else {
            return (new CommonResult(200, "失败", null));
        }
    }

}
