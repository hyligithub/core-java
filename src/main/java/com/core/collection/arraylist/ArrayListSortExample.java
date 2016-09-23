package com.core.collection.arraylist;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/**
 * Created by lihuiyan on 2016/9/23.
 */
public class ArrayListSortExample {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            list.add(random.nextInt(1000));
        }
        Comparator<Integer> comparator = new ArrayListSortExample().new MyComparator();
        list.sort(comparator);
        System.out.println(list);
        list.sort((o1, o2) -> {
            return (o2 - o1);
        });
        System.out.println(list);
    }

    class MyComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }
}
