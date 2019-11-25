package com.ttdys108.commons.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {
    SUCCESS("000000", null),
    SYSTEM_ERROR("999999", "system error"),
    ILLEGAL_ARGUMENT("100000", "illegal argument"),

    ;


    private ErrorCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    private String code;
    private String msg;


}
