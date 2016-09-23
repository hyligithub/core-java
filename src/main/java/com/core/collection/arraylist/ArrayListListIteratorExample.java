package com.core.collection.arraylist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by lihuiyan on 2016/9/23.
 */
public class ArrayListListIteratorExample {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        ListIterator<Integer> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            int a = listIterator.previous();
            System.out.print(a);
            if (a == 5) {
                listIterator.remove();
                listIterator.add(20);
            }
        }
        System.out.println(list);

        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer i = (Integer) iterator.next();
            list.remove(i);
        }

    }
}
