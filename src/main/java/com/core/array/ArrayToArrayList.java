package com.core.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by lihuiyan on 2016/9/17.
 */
public class ArrayToArrayList {
    public static void main(String[] args) {
        String[] str = {"1", "2", "3"};
        List<String> list = new ArrayList<String>();
        list = Arrays.asList(str);
        for (String s : list) {
            System.out.println(s);
        }
        str[0] = "5";
        for (String s : list) {
            System.out.println(s);
        }
        list = new ArrayList<String>();
//        list.add("A");//UnsupportedOperationException
        Collections.addAll(list,str);
        for (String s : list) {
            System.out.println(s);
        }
        list.add("A");
        for (String s : list) {
            System.out.println(s);
        }

    }
}
