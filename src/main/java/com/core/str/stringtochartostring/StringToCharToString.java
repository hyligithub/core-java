package com.core.str.stringtochartostring;

import java.util.Arrays;

/**
 * Created by lihuiyan on 2016/9/15.
 */
public class StringToCharToString {

    public static void main(String[] args) {
        String a = "ABC";
        char[] charArray = a.toCharArray();
        for (char c : charArray) {
            System.out.println(c);
        }
        String b = Arrays.toString(charArray);//charArray.toString 不对
        System.out.println(b);

        char c = a.charAt(1);
        System.out.println(c);

        String d = Character.toString(c);
        System.out.println(d);

        a = a.replaceAll("C", "c");
        System.out.println(a);

    }
}
