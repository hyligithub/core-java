package com.core.collection.map;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Created by lihuiyan on 2016/9/27.
 */
public class HashMapExample {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("A", "A");
        map.put("B", "B");
        map.put("C", "C");
        System.out.println(map);

        String result = map.putIfAbsent("A", "D");//jdk8
        System.out.println(result + "***" + map);

        String s = map.putIfAbsent("D", "D");
        System.out.println(s + "***" + map);
        System.out.println("testForEach start");
        testForEach();
        testReplaceAll();
        testComputeIfAbsent();
        testComputeIfPresent();
        testCompute();
        testMerge();

    }

    private static void testForEach() {
        Map<String, String> map = new HashMap<>();
        map.put("A", "A");
        map.put("B", "B");
        map.put(null, "NULL_KEY");
        map.put("NULL_VALUE", null);
        BiConsumer<String, String> b = new MyBiConsumer();
        map.forEach(b);
        map.forEach((k, v) -> {
            System.out.println(k + "***" + v);
        });
    }

    static class MyBiConsumer implements BiConsumer<String, String> {

        @Override
        public void accept(String s, String s2) {
            System.out.println(s + "---" + s2);
        }
    }

    private static void testReplaceAll() {
        Map<String, String> map = new HashMap<>();
        map.put("A", "A");
        map.put("B", "B");
        map.put(null, "NULL_KEY");
        map.put("NULL_VALUE", null);
        map.replaceAll((k, v) -> {
            if (k != null)
                return k + v;
            else return v;
        });

        System.out.println(map);
        BiFunction<String, String, String> s = new MyBifunction();
        map.replaceAll(s);
        System.out.println(map);
    }

    static class MyBifunction implements BiFunction<String, String, String> {

        @Override
        public String apply(String s, String s2) {
            if (s != null)
                return s + s2;
            return s2;
        }
    }

    private static void testComputeIfAbsent() {
        Map<String, String> map = new HashMap<>();
        map.put("A", "A");
        map.put("B", "B");
        map.put(null, "NULL_KEY");
        map.put("NULL_VALUE", null);
        Function<String, String> myFunction = new MyFunction();
        map.computeIfAbsent("B", myFunction);
        map.computeIfAbsent("C", myFunction);

        map.computeIfAbsent("4", v -> {
            return v;
        });//key =4 不存在
        map.computeIfAbsent("5", v -> {
            return null;
        });//key =5 ,因为返回null,所以不会插入
        System.out.println(map);
    }

    static class MyFunction implements Function<String, String> {

        @Override
        public String apply(String s) {
            return s;
        }
    }

    private static void testComputeIfPresent() {
        Map<String, String> map = new HashMap<>();
        map.put("A", "A");
        map.put("B", "B");
        map.put(null, "NULL_KEY");
        map.put("NULL_VALUE", null);

        BiFunction<String, String, String> biFunction = new MyBiFunction1();
        for (String key : map.keySet()) {
            map.computeIfPresent(key, biFunction);
        }
        System.out.println(map);// {null=nullNULL_KEY, A=AA, B=BB, NULL_VALUE=null} 值为null不会计算
        map.computeIfPresent("A", (k, v) -> {
            return null;
        });//key A 会被删除

        System.out.println(map);
    }

    static class MyBiFunction1 implements BiFunction<String, String, String> {

        /**
         * Applies this function to the given arguments.
         *
         * @param s  the first function argument
         * @param s2 the second function argument
         * @return the function result
         */
        @Override
        public String apply(String s, String s2) {
            return s + s2;
        }
    }

    private static void testCompute() {
        Map<String, String> map = new HashMap<>();
        map.put("A", "A");
        map.put("B", "B");
        map.put(null, "NULL_KEY");
        map.put("NULL_VALUE", null);
        for (String key : map.keySet()) {
            map.compute(key, (k, v) -> {
                return k + v;
            });
        }
        map.compute("5", (k, v) -> {
            return k + v;
        });//key不存在,value=null
        System.out.println(map);
    }

    private static void testMerge() {
        Map<String, String> map = new HashMap<>();
        map.put("A", "A");
        map.put("B", "B");
//        map.put(null, "NULL_KEY");
//        map.put("NULL_VALUE", null);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            //merge throws NullPointerException if key or value is null
            map.merge(key, value, (k, v) -> {
                return k + v;
            });
        }
        System.out.println(map);
        map.merge("A", "A", (k, v) -> {
            return null;
        });//remove
        map.merge("C", "C", (k, v) -> {
            return k + v;
        });
        System.out.println(map);
    }
}
