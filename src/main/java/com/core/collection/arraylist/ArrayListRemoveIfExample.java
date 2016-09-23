package com.core.collection.arraylist;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by lihuiyan on 2016/9/23.
 */
public class ArrayListRemoveIfExample {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        Predicate<Integer> filter = new ArrayListRemoveIfExample().new MyPreficate();
        list.removeIf(filter);
        System.out.println(list);

        list.removeIf(x -> {
            return x % 3 == 0;
        });
        System.out.println(list);
    }

    class MyPreficate implements Predicate<Integer> {

        @Override
        public boolean test(Integer integer) {
            return integer % 2 == 0;
        }
    }
}
