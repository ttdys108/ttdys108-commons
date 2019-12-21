package com.ttdys108.commons.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {
    SUCCESS("000000", null),
    SYSTEM_ERROR("999999", "system error"),
    ILLEGAL_ARGUMENT("100000", "illegal argument"),
    LOGIN_VERIFY_FAIL("401000", "wrong username or password"),
    LOGIN_DYCODE_FAIL("401000", "wrong dynamic code"),

    ;


    private ErrorCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    private String code;
    private String msg;


}
