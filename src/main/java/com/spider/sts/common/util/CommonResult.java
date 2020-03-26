package com.spider.sts.common.util;

/**
 * 结果返回统一格式
 * @param <T>
 */
public class CommonResult<T> {

    private int code;

    private String message;

    private T data;

    public CommonResult(int code, String message, T data){
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 成功返回结果数据
     * @param data 数据
     * @return
     */
    public static <T> CommonResult<T> success(T data){
        return new CommonResult<>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }

    /**
     * 成功
     * @return
     */
    public static  CommonResult success(){
        return new CommonResult<>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), null);
    }

    /**
     * 失败
     * @param message 提示信息
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> failed(String message){
        return new CommonResult<>(ResultCode.FAILED.getCode(), message, null);
    }

    /**
     * 失败
     * @param resultCode 结果码和说明
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> failed(ResultCode resultCode){
        return new CommonResult<>(resultCode.getCode(), resultCode.getMessage(), null);
    }

}
