package com.core.collection.arraylist;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

/**
 * Created by lihuiyan on 2016/9/23.
 */
public class ArrayListReplaceAllExample {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        UnaryOperator<Integer> operator = new ArrayListReplaceAllExample().new MyUnaryOperator();
        list.replaceAll(operator);
        System.out.println(list);
        list.replaceAll(x -> {
            return x * 5;
        });
        System.out.println(list);
    }

    class MyUnaryOperator implements UnaryOperator<Integer> {

        @Override
        public Integer apply(Integer integer) {
            return integer * 10;
        }
    }
}
