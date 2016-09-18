package com.core.annotation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lihuiyan on 2016/9/18.
 */
public class AnnotationExample {
    public static void main(String[] args) {
        genericTest();
        oldMethod();
    }

    @Deprecated
    @MehtodInfo(name = "oldMehtod", date = "2016/09/18", version = 1)
    public static void oldMethod() {
        System.out.println("this is a old method,don't use it");
    }

    @Override
    @MehtodInfo(name = "toString", date = "2016/09/18", author = "lihy", version = 2)
    public String toString() {
        return "Override toString";
    }

    @SuppressWarnings({"unchecked", "deprecation"})
    @MehtodInfo(name = "genericTest", author = "lihy", date = "2016/09/18", version = 10)
    public static void genericTest() {
        List l = new ArrayList();
        l.add("abc");
        oldMethod();
    }

}
