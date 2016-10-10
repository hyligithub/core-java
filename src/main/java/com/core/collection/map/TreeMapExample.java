package com.core.collection.map;

import java.util.*;

/**
 * Created by lihuiyan on 2016/10/10.
 */
public class TreeMapExample {
    public static void main(String[] args) {
//        testOriginalAPIS();
//        testSubMapAPIS();
        testNavigableMapAPIS();
    }

    /**
     * 测试常用API
     */
    private static void testOriginalAPIS() {
        Random random = new Random();
        TreeMap map = new TreeMap();
        map.put("one", random.nextInt(10));
        map.put("two", random.nextInt(10));
        map.put("three", random.nextInt(10));

        System.out.println("---testOriginalAPIS begin:---:" + map);

        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            String key = (String) entry.getKey();
            Integer value = (Integer) entry.getValue();
            System.out.println(key + "---" + value);
        }

        System.out.println(map.size());

        System.out.println("contains key:two:" + map.containsKey("two"));
        System.out.println("contains key:five:" + map.containsKey("five"));
        System.out.println("contains value:7:" + map.containsValue(7));

        map.remove("three");
        System.out.println(map);

        map.clear();

        System.out.println(map);
        System.out.println("---testOriginalAPIS END");
    }

    private static void testSubMapAPIS() {
        TreeMap map = new TreeMap();
        map.put("a", 101);
        map.put("b", 102);
        map.put("c", 103);
        System.out.println("----testSubMapAPIS BEGIN----");
        System.out.println(map);
        //返回当前map的头部，不包含toKey,实际是将map进行排序
        System.out.println("test headMap:" + map.headMap("c"));
        //返回当前map的头部，包含toKey
        System.out.println("test headMap:" + map.headMap("c", true));
        System.out.println("test headMap:" + map.headMap("c", false));

        System.out.println("test subMap:" + map.subMap("a", "c"));
        System.out.println("test subMap:" + map.subMap("a", true, "c", false));
        System.out.println("test subMap:" + map.subMap("a", false, "c", true));
        System.out.println("test subMap:" + map.subMap("a", true, "c", true));
        System.out.println("test subMap:" + map.subMap("a", false, "c", false));

        System.out.println(map.navigableKeySet());
        System.out.println(map.descendingKeySet());
        System.out.println("----testSubMapAPIS END----");
    }

    private static void testNavigableMapAPIS() {
        NavigableMap map = new TreeMap();
        map.put("a", 111);
        map.put("b", 222);
        map.put("c", 333);
        map.put("d", 444);
        System.out.println("----testNavigableMapAPIS  begin----");
        System.out.println(map);
        System.out.println(map.firstKey() + "----" + map.firstEntry());
        System.out.println(map.lastKey() + "----" + map.lastEntry());
        // 小于等于 key 的最大键
        System.out.println(map.floorKey("c"));
        //小于 key的最大键
        System.out.println(map.lowerKey("c"));
        //大于等于key的最小键
        System.out.println(map.ceilingKey("a"));
        //大于key的最小键
        System.out.println(map.higherKey("a"));
        System.out.println("----testNavigableMapAPIS  end----");
    }
}
