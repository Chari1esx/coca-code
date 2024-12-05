package com.charless.cocacode.common.model;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class BaseResponse<T> implements Serializable {
    private final Integer code;
    private final String msg;
    private final String detail;
    private final T data;

    public BaseResponse(Integer code, String msg, String detail, T data) {
        this.code = code;
        this.msg = msg;
        this.detail = detail;
        this.data = data;
    }

    public BaseResponse(StatusCode statusCode) {
        this(statusCode.getCode(), statusCode.getMsg(), null, null);
    }

    public BaseResponse(StatusCode statusCode, T data) {
        this(statusCode.getCode(), statusCode.getMsg(), null, data);
    }

    public BaseResponse(StatusCode statusCode, String detail) {
        this(statusCode.getCode(), statusCode.getMsg(), detail, null);
    }

    public BaseResponse(Integer code, String msg, String detail) {
        this(code, msg, detail, null);
    }
}
