package com.jsg.examples.utils.http请求.param;


import com.alibaba.fastjson.JSONObject;

public class InputParam<T> extends JSONObject {

    private T content;//参数内容(满足json规范的字符串),具体内容和相关接口有关
}
