package com.jsg.examples.config.utils;


import com.jsg.examples.config.constants.BaseConstants;
import com.jsg.examples.entity.CommonResult;

public class InvocationResult extends CommonResult  {
    // 系统返回码
    private Integer  code;
    // 处理结果(成功/失败)
    private String   message;
    // 返回结果集
    private Object   body;

    public InvocationResult(Integer code, String message, Object data) {
        super(code, message, data);
    }



    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }

    /**
     * 返回类(默认返回成功)
     *
     * @return
     */
    public static CommonResult newInstance()
    {
        CommonResult result = new CommonResult();
        result.setCode(BaseConstants.CODE_SUCCESS);
        result.setMessage(BaseConstants.MESSAGE_SUCCESS);
        return result;
    }
}
