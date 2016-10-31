package com.core;

/**
 * Created by lihuiyan on 2016/10/31.
 */
public class PrintUtil<T> {
    public static <T> void printForString(T t) {
        System.out.println(t.toString());
    }

    public static <T> void print(T t) {
        System.out.println(t);
    }

    public static <T> void printf(String format, T... t) {
        System.out.printf(format, t);
    }
}
