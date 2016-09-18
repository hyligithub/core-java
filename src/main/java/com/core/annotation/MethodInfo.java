package com.core.annotation;

import java.lang.annotation.*;

/**
 * Created by lihuiyan on 2016/9/18.
 */
@Documented
@Inherited
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodInfo {
    String name();

    String author() default "lihuiyan";

    String date();

    int version() default 1;

}
