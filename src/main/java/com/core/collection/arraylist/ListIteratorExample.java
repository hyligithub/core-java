package com.core.collection.arraylist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by lihuiyan on 2016/9/23.
 * list迭代器使用
 */
public class ListIteratorExample {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next());
        }
        iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer integer = (Integer) iterator.next();
            if (integer % 2 == 0) list.remove(integer); //fail-fast 机制
        }
        System.out.print(list);
    }
}
