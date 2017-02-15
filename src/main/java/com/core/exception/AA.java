package com.core.exception;

/**
 * Created by lihuiyan on 2016/11/14.
 */
public class AA {
    public static void main(String[] args) {
        AA a = new AA();
        a.methodA();
    }

    private void methodA() {
        B b = new B();
        try {
            b.methodB();
        } catch (MyRuntimeException e) {
            System.out.println("this is MyRuntimeException");
        } catch (RuntimeException e) {
            System.out.println("this is RuntimeException");
        } catch (Exception e) {
            System.out.println("this is Exception");
        }
    }
}
