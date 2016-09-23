package com.core.collection.arraylist;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by lihuiyan on 2016/9/23.
 */
public class ArrayListForEachExample {
    public static void main(String[] args){
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("e");
        list.add("i");
        list.add("o");
        Consumer<Object> consumer = new ArrayListForEachExample().new MyConsumer();
        list.forEach(consumer);
        //lamda style
        list.forEach(x -> {System.out.println("Processed "+x);});

    }

    class MyConsumer implements Consumer<Object>{

        @Override
        public void accept(Object o) {
            System.out.println(o);
        }
    }
}
