package com.ttdys108.commons.http;

import com.ttdys108.commons.exception.ErrorCode;
import com.ttdys108.commons.exception.ServiceException;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Response<T> {
    private String code;
    private String msg;
    private T data;

    public Response() {}

    public static <T> Response<T> create(String code, String msg, T data) {
        Response<T> response = new Response<>();
        response.code = code;
        response.msg = msg;
        response.data = data;
        return response;
    }

    public static <T> Response<T> success(T data) {
        return error(ErrorCode.SUCCESS, data);
    }

    public static <T> Response<T> error(ErrorCode errorCode, T data) {
        return create(errorCode.getCode(), errorCode.getMsg(), data);
    }

    public static <T> Response<T> error(ErrorCode errorCode) {
        return error(errorCode, null);
    }

    public static <T> Response<T> error(ServiceException exception) {
        return create(exception.getCode(), exception.getMsg(), null);
    }

    public static <T> Response<T> error() {
        return error(ErrorCode.SYSTEM_ERROR, null);
    }

}
