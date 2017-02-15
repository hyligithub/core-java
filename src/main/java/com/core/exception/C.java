package com.core.exception;

import java.io.IOException;

/**
 * Created by lihuiyan on 2016/11/14.
 */
public class C {

    public void methoC() {
        try {
            System.out.println("this is C class");
            throw new IOException("this is IO error");
        } catch (MyRuntimeException e) {
            System.out.println("1-----------");
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (RuntimeException e) {
            System.out.println("2-----------");
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (Exception e) {
            System.out.println("3-----------");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}

