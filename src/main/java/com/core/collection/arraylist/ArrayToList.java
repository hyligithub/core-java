package com.core.collection.arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lihuiyan on 2016/9/23.
 * 数组转换成List
 */
public class ArrayToList {
    public static void main(String[] args) {

        String[] array = {"a", "e", "i", "o", "u"};
        List<String> list = Arrays.asList(array);
        for (String s : list) {
            System.out.println(s);
        }
//        list.remove("a");

        List<String> tmpList = new ArrayList<String>();
        for (String s : array) {
            tmpList.add(s);
        }
        tmpList.remove("a");
        tmpList.add("asdf");
        tmpList.clear();
        for (String s : tmpList) {
            System.out.println(s+"1");
        }

    }
}
