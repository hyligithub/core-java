package com.core.str.stringpool;

/**
 * Created by lihuiyan on 2016/9/15.
 * http://tech.meituan.com/in_depth_understanding_string_intern.html
 */
public class StringPool {
    public static void main(String[] args) {
        String s = new String("abc");
//        System.out.println(s.intern());
        String s2 = "abc";
        s.intern();
        System.out.println(s == s2);

        String s3 = new String("1") + new String("1");
//        s3.intern();
        String s4 = "11";
        s3.intern();
        System.out.println(s3 == s4);
    }
}
