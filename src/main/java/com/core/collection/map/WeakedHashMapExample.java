package com.core.collection.map;

import java.util.Map;
import java.util.WeakHashMap;

/**
 * Created by lihuiyan on 2016/10/10.
 */
public class WeakedHashMapExample {
    public static void main(String[] args) {
        testWeakKey();
    }

    private static void testWeakKey() {
        String one = new String("one");
        String two = new String("two");
        String three = new String("three");
        Map map = new WeakHashMap();
        map.put(one, 1);
        map.put(two, 2);
        map.put(three, 3);
        System.out.println(map);
        one = null;
        System.gc();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("gc:" + map);

    }
}
