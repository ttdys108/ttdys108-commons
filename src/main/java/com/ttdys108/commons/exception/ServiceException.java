package com.ttdys108.commons.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServiceException extends Exception {
    private String code;
    private String msg;

    public ServiceException() {}

    public ServiceException(String code, String msg, Throwable cause) {
        super(cause);
        this.code = code;
        this.msg = msg;
    }


}
