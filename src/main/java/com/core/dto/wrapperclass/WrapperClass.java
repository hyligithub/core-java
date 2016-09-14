package com.core.dto.wrapperclass;

/**
 * Created by lihuiyan on 2016/9/14.
 */
public class WrapperClass {

    public static void main(String[] args){
        int i =10;
        char c = 'a';
        method(c);

    }

    public static void method(Object o){
        System.out.println(o);
    }
}
