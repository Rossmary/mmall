package com.company.common;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * 服务器返回的信息封装类ServerResponse
 * Created by Administrator on 2017/11/29 0029.
 */
/*
*使用该注解，jackson不对值为null的属性进行处理，结果不显示该属性（msg,data）
* */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ServerResponse<T> {
    private int status;
    private String msg;
    private T data;

    public ServerResponse() {
    }

    public ServerResponse(int status) {
        this.status = status;
    }
    public ServerResponse(int status, T data) {
        this.status = status;
        this.data = data;
    }
    public ServerResponse(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }
    public ServerResponse(int status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
    /*
    *isSuccess方法返回boolean值会被序列化后放入json数据中
    * 通过该注解，使属性不在序列化结果中出现
    * */
    @JsonIgnore
    public boolean isSuccess(){
        return this.status == ResponseCode.SUCCESS.getCode();
    }
    //SUCCESS返回对象
    public static <T> ServerResponse<T> createSuccessResponse() {
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode());
    }

    public static <T> ServerResponse<T> createSuccessMessageResponse(String msg) {
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(), msg);
    }

    public static <T> ServerResponse<T> createSuccessResponse(String msg, T data) {
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(), msg, data);
    }

    public static <T> ServerResponse<T> createSuccessResponse(T data) {
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(), data);
    }

    //ERROR时返回对象
    public static <T> ServerResponse<T> createErrorResponse() {
        return new ServerResponse<T>(ResponseCode.ERROR.getCode());
    }

    public static <T> ServerResponse<T> createErrorMessageResponse(String msg) {
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(), msg);
    }

    public static <T> ServerResponse<T> createErrorResponse(String msg, T data) {
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(), msg, data);
    }

    public static <T> ServerResponse<T> createErrorResponse(T data) {
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(), data);
    }

    //其他类型返回对象
    public static <T> ServerResponse<T> createErrorCodeMsg(int errCode,String errMsg) {
        return new ServerResponse<T>(errCode,errMsg);
    }
}

