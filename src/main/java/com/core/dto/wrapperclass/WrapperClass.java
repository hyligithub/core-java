package com.core.dto.wrapperclass;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lihuiyan on 2016/9/14.
 */
public class WrapperClass {

    public static void main(String[] args) {
        int i = 10;
        int j = i + 3;
        char c = 'a';
        method(c);
        Integer a = new Integer(i);
        a = null;
        List<Integer> lis = new ArrayList<Integer>();
        lis.add(a);
        lis.add(j);

    }

    public static void method(Object o) {
        System.out.println(o);
    }
}
