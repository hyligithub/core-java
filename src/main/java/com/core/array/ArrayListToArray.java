package com.core.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lihuiyan on 2016/9/17.
 */
public class ArrayListToArray {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("3");

        String[] strArray = list.toArray(new String[list.size()]);
        System.out.println(Arrays.toString(strArray));


    }
}
