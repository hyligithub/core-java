package com.core.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by lihuiyan on 2016/9/26.
 */
public class MapExample {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("A", "A");
        map.put("B", "B");
        map.put("C", "C");
        map.put("D", "D");
        map.put(null, "NULL_KEY");
        map.put("NULL_VALUE", null);
        String value = map.get("C");
        System.out.println(value);
        value = map.getOrDefault("E", "Default value");
        System.out.println("key = E value = " + value);

        boolean keyExsists = map.containsKey(null);
        System.out.println(keyExsists);

        boolean valueExsists = map.containsValue(null);
        System.out.println(valueExsists);
        Set<Map.Entry<String, String>> set = map.entrySet();
        for (Map.Entry entry : set) {
            System.out.println(entry.getKey() + "***" + entry.getValue());
        }

        Map<String, String> map1 = new HashMap<>();
        map1.putAll(map);
        System.out.println(map1);

        String nullKeyValue = map.remove(null);
        System.out.println(nullKeyValue);
        System.out.println(map1);

        Set<String> keySet = map.keySet();
        System.out.println(keySet);
        Collection<String> values = map.values();
        System.out.println(values);
        map.clear();
        System.out.println(map.isEmpty());
    }
}
