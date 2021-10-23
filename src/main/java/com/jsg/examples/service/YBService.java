package com.jsg.examples.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jsg.examples.entity.CommonResult;
import com.jsg.examples.entity.YBLogEntity;

import java.io.IOException;
import java.util.List;

public interface YBService {

    Object query_ZYMZCX(YBLogEntity ybLogEntity);
    CommonResult query_DRZYMZCX(JSONObject jsonObject);
    void test02(String str) throws IOException;
}
