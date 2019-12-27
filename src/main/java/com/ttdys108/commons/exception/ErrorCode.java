package com.ttdys108.commons.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {
    //0开头表示成功
    SUCCESS("000000", null),

    //1开头参数问题
    ILLEGAL_ARGUMENT("100000", "illegal argument"),
    REGISTER_USER_EXISTS("110000", "user already exists"),
    UNIQUE_ERROR("120000", "unique constraint error"),

    //4开头权限问题
    LOGIN_VERIFY_FAIL("401000", "wrong username or password"),
    LOGIN_DYCODE_FAIL("401001", "wrong dynamic code"),
    ILLEGAL_STATUS("402000", "illegal status"),

    //9开头系统错误
    SYSTEM_ERROR("999999", "system error"),

    ;


    private ErrorCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    private String code;
    private String msg;


}
