package com.core.exception;

/**
 * Created by lihuiyan on 2016/10/14.
 */
public class MyException extends Exception {
    private static final long serialVersionID = 1L;
    private String errorCode = "Unknown_Exception";

    public MyException(String msg, String errorCode) {
        super(msg);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
