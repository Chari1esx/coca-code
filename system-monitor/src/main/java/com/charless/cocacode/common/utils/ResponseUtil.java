package com.charless.cocacode.common.utils;

import com.charless.cocacode.common.model.BaseResponse;
import com.charless.cocacode.common.model.StatusCode;

import static com.charless.cocacode.common.model.StatusCode.FAILED;
import static com.charless.cocacode.common.model.StatusCode.SUCCESS;

public class ResponseUtil {
    public static BaseResponse<?> success() {
        return new BaseResponse<>(SUCCESS);
    }

    public static <T> BaseResponse<T> success(T data) {
        return new BaseResponse<>(SUCCESS, data);
    }

    public static BaseResponse<?> fail() {
        return new BaseResponse<>(FAILED);
    }

    public static BaseResponse<?> fail(StatusCode statusCode) {
        return new BaseResponse<>(statusCode);
    }

    public static BaseResponse<?> fail(StatusCode statusCode, String detail) {
        return new BaseResponse<>(statusCode, detail);
    }

    public static BaseResponse<?> fail(Integer code, String msg, String detail) {
        return new BaseResponse<>(code, msg, detail);
    }
}
