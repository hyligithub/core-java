package com.core.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lihuiyan on 2016/10/11.
 */
public class GenericExample {

    public static void main(String[] args) {
        genericOrNotGeneric();
    }

    private static void genericOrNotGeneric() {
        List list = new ArrayList();//没有使用泛型,list中对象的类型默认为Object,所以可以加入任何类型，编译时没有问题
        list.add("this is a String");
        list.add(1);
        for (int i = 0; i < list.size(); i++) {
//            String name = (String) list.get(i);//运行时,在list遍历的时候，不知道里面具体的类型是什么，如果强制转换，就会抛异常
        }
        /**
         * 为了解决上面的问题，出现了泛型，容器中指定了具体的类型，实现了编译期检查
         * 下面的list只能存储String类型的对象
         */
        List<String> listStr = new ArrayList();
        listStr.add("this is a String list");
        listStr.add("this is a str");
        //listStr.add(1);//编译时就会报错
        for (String str : listStr) {
            System.out.println(str);
        }
    }
}
