package com.core.enumexample;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Set;

/**
 * Created by lihuiyan on 2016/9/19.
 */
public class EnumExample {

    public static void main(String[] args) {
        useEnumValues();
        useEnumValueOf();
        useEnumMethods();
        useEnumSwitch(ThreadStateEnum.DEAD);
        useEnumSwitch(ThreadStateEnum.RUNNING);
        useEnumMap();
        useEnumSet();
    }

    private static void useEnumValues() {
        ThreadStateEnum[] enums = ThreadStateEnum.values();
        for (ThreadStateEnum t : enums) {
            System.out.println(t.getDetail() + "-" + t.getPriority());
        }
    }

    private static void useEnumValueOf() {
        ThreadStateEnum s = ThreadStateEnum.valueOf(ThreadStateEnum.class, "START");
        try {
            ThreadStateEnum s1 = ThreadStateEnum.valueOf(ThreadStateEnum.class, "Start");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        System.out.println(s.getDetail() + "--" + s.getPriority());
    }

    private static void useEnumMethods() {
        ThreadStateEnum s = ThreadStateEnum.START;
        System.out.println(s.getDetail() + "--" + s.getPriority());
        s.setPriority(10);
        System.out.println(s.getDetail() + "--" + s.getPriority());
    }

    private static void useEnumSwitch(ThreadStateEnum th) {
        switch (th) {
            case START:
                System.out.println("start");
                break;
            case RUNNING:
                System.out.println("running");
                break;
            case WAITING:
                System.out.println("waiting");
                break;
            case DEAD:
                System.out.println("dead");
                break;
        }
    }

    private static void useEnumMap() {
        EnumMap<ThreadStateEnum, String> map = new EnumMap<ThreadStateEnum, String>(ThreadStateEnum.class);
        map.put(ThreadStateEnum.START, "this is start");
        map.put(ThreadStateEnum.RUNNING, "this is running");
        map.put(ThreadStateEnum.WAITING, "this is waiting");
        map.put(ThreadStateEnum.DEAD, "this is dead");

        Set<ThreadStateEnum> set = map.keySet();
        for (ThreadStateEnum th : set) {
            System.out.println("key:" + th.toString() + ",value:" + map.get(th));
        }
    }

    private static void useEnumSet() {
        EnumSet<ThreadStateEnum> set = EnumSet.allOf(ThreadStateEnum.class);
        for (ThreadStateEnum th : set) {
            System.out.println(th.getDetail() + "--" + th.getPriority());
        }
    }
}
