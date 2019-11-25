package com.ttdys108.commons.http;

import com.ttdys108.commons.exception.ErrorCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Response<T> {

    public Response() {}

    public Response(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Response(ErrorCode errorCode, T data) {
        this(errorCode.getCode(), errorCode.getMsg(), data);
    }

    private String code;
    private String msg;
    private T data;

    public static <T> Response<T> success(T data) {
        return new Response<>(ErrorCode.SUCCESS, data);
    }

    public static <T> Response<T> sysError() {
        return new Response<>(ErrorCode.SYSTEM_ERROR, null);
    }
}
