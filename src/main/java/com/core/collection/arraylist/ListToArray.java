package com.core.collection.arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lihuiyan on 2016/9/23.
 * list 转换成 数组
 */
public class ListToArray {
    public static void main(String[] args){
        List<String> list = new ArrayList();
        list.add("a");list.add("e");
        String[] array = new String[list.size()];
        array = list.toArray(array);
        System.out.println(Arrays.toString(array));
    }
}
