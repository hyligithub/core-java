package com.core.collection.failfast;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by lihuiyan on 2016/10/11.
 */
public class FailFastExample {

    public static void main(String[] args) {
//        testArrayListFailFast();
//        testMapFailFast();
        testThreadSafeIterator();
    }

    private static void testArrayListFailFast() {
        List<String> list = new ArrayList();
        list.add("1");
        list.add("2");
        list.add("3");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String value = iterator.next();//此处会比较modCount==expectCount,不等就会抛异常
            if (value.equals("3"))
                list.remove("3");//此处会更新modCount
        }
    }

    private static void testMapFailFast() {
        Map<String, String> map = new HashMap<>();
        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");
        Iterator iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            String key = (String)iterator.next();
            System.out.println(map.get(key));
            if (key.equals("1")) {
                map.remove("1");
            }
        }
    }

    private static void testThreadSafeIterator() {
        List<String> list = new CopyOnWriteArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            String value = (String) iterator.next();
            if (value.equals("two"))
                list.remove("two");
        }
        System.out.println(list.toString());

        Map<String, String> map = new ConcurrentHashMap<>();
        map.put("1", "one");
        map.put("2", "two");
        map.put("3", "three");
        Iterator iterator1 = map.keySet().iterator();
        while (iterator1.hasNext()) {
            String key = (String)iterator1.next();
            System.out.println(map.get(key));
            if ("2".equals(key)) {
                map.remove(key);
                map.put("4","four");
                map.put("5","five");
            }
        }
        System.out.println(map);
    }
}
