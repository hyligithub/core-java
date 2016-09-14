package com.core.dto.boxing;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lihuiyan on 2016/9/14.
 */
public class AutoBoxingUnboxing {
    public static void main(String[] args) {
        int i = 10;
        long j = 120L;
        method1(i);//boxing
        List<Long> list = new ArrayList<Long>();
        list.add(j);//boxing
    }

    private static void method1(Integer i) {
        int m = i;//unboxing,Integer.intValue() runtime
        method2(i);//unboxing
    }

    private static void method2(int i) {
        System.out.println(i);
    }
}
