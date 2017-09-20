package com.core;

/**
 * Created by lihuiyan on 2016/11/18.
 * 传值还是传引用？ java实际都是传值的
 * 基本类型作为参数传递时，是传递参数的拷贝
 * 对象作为参数传递时，是把对象的内存地址拷贝一份传给了参数
 */
public class ValueOrReference {

    public static void main(String[] args){
        StringBuffer sb = new StringBuffer("aaa");
        PrintUtil.printForString("before:"+sb);
        method(sb);
        PrintUtil.printForString("after:"+sb);
    }

    private static void method(StringBuffer sb){
        StringBuffer sb1 = new StringBuffer("111");
        sb = sb1;
        sb.append("bbb");
    }
}
