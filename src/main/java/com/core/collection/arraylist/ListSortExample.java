package com.core.collection.arraylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by lihuiyan on 2016/9/23.
 * list排序
 */
public class ListSortExample {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            list.add(random.nextInt(1000));
        }
        Collections.sort(list);
        System.out.println(list);
    }
}
