package com.spider.sts.common.util;

public enum ResultCode {

    SUCCESS(200, "成功"),
    FAILED(500,"失败"),
    //用户模块
    USERNAME_USED(10001,"该用户名已被使用");

    private int code;

    private String message;

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode(){
        return code;
    }

    public String getMessage(){
        return message;
    }

}
