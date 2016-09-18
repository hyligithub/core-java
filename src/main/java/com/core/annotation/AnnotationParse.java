package com.core.annotation;

import java.lang.reflect.Method;

/**
 * Created by lihuiyan on 2016/9/18.
 */
public class AnnotationParse {

    public static void main(String[] args) {
        try {
            for (Method method : AnnotationParse.class.getClassLoader().loadClass("com.core.annotation.AnnotationExample.class").getMethods()) {


            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
