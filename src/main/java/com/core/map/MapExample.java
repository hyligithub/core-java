package com.core.map;

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

    }
}
