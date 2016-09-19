package com.core.annotation;


import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Created by lihuiyan on 2016/9/18.
 */
public class AnnotationParse {

    public static void main(String[] args) {
        try {
            for (Method method : AnnotationParse.class.getClassLoader().loadClass("com.core.annotation.AnnotationExample").getMethods()) {

                if (method.isAnnotationPresent(com.core.annotation.MethodInfo.class)) {
                    for (Annotation an : method.getDeclaredAnnotations()) {
                        System.out.println("method:" + method + ",ano=" + an);
                    }
                    MethodInfo methodInfo = method.getAnnotation(MethodInfo.class);
                    if (methodInfo.version() == 10) {
                        System.out.println("method version =10 ," + method);
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
