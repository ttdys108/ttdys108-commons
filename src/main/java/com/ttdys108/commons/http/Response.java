package com.ttdys108.commons.http;

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

    private String code;
    private String msg;
    private T data;

    public static <T> Response<T> success(T data) {
        return new Response<>("000000", null, data);
    }

    public static <T> Response<T> sysError() {
        return new Response<>("999999", "system error", null);
    }
}
