package com.core.exception;

/**
 * Created by lihuiyan on 2016/11/14.
 */
public class MyRuntimeException extends RuntimeException {
    public MyRuntimeException(String msg) {
        super(msg);
    }

    public MyRuntimeException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
