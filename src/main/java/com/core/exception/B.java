package com.core.exception;

/**
 * Created by lihuiyan on 2016/11/14.
 */
public class B {

    public void methodB() throws MyRuntimeException {
        C c = new C();
        c.methoC();
    }
}
