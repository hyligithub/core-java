package com.core.str.compare;

/**
 * Created by lihuiyan on 2016/9/15.
 */
public class StringCompareToExample {

    public static void main(String[] args) {
        String s = "ABC";
        String s2 = "DEF";
        System.out.println(s.compareTo(s2));//-3 ,因为是比较字符的大小
        System.out.println(s.compareToIgnoreCase("abc"));

        char a = 'A';
        char b = 'D';
        System.out.println(a - b);
    }
}
