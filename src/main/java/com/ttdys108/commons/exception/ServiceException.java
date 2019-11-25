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

    public ServiceException(String code, String msg) {
        this(code, msg, null);
    }

    public ServiceException(ErrorCode errorCode, Throwable cause) {
        super(cause);
        this.code = errorCode.getCode();
        this.msg = errorCode.getMsg();
    }

    public ServiceException(ErrorCode errorCode) {
        this(errorCode, (Throwable) null);
    }

    public ServiceException(ErrorCode errorCode, String msg, Throwable cause) {
        super(cause);
        this.code = errorCode.getCode();
        this.msg = msg;
    }

    public ServiceException(ErrorCode errorCode, String msg) {
        this(errorCode, msg, null);
    }

    public static ServiceException sysError(Throwable cause) {
        return new ServiceException(ErrorCode.SYSTEM_ERROR, cause);
    }

}
