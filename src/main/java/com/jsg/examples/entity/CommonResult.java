package com.jsg.examples.entity;

/**
 * 返回
 * @param <T>
 */

public class CommonResult<T> {
    private Integer code;  //状态码
    private String  message; //状态码信息
    private T       data;   //具体数据

    public CommonResult(Integer code1, String message1, T data1){
        this.code=code1;
        this.message=message1;
        this.data=data1;
    }

    public CommonResult() {
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
