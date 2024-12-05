package com.charless.cocacode.common.model;

import lombok.Getter;

@Getter
public enum StatusCode {
    SUCCESS(20000, "请求成功"),
    PARAM_ERROR(40000, "请求参数错误"),
    NOT_LOGIN(40100, "用户未登录"),
    NOT_AUTH(40101, "用户无权限"),
    NOT_EXIST(40102, "用户不存在"),
    NOT_ALLOWED(40103, "用户封禁"),
    FORBIDDEN(40300, "禁止访问"),
    NOT_FOUND(40400, "资源不存在"),
    FAILED(50000, "请求失败"),
    SYSTEM_ERROR(50001, "系统错误");

    private final Integer code;
    private final String msg;

    StatusCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
