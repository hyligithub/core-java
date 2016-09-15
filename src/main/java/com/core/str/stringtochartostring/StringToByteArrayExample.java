package com.core.str.stringtochartostring;

import java.util.Arrays;

/**
 * Created by lihuiyan on 2016/9/16.
 */
public class StringToByteArrayExample {

    public static void main(String[] args) {
        String s = "www.baidu.com";
        byte[] bytes = s.getBytes();
        for (byte b : bytes) {
            System.out.println(Byte.toString(b));
        }
        String a = Arrays.toString(bytes);
        System.out.println(a);
        String c = new String(bytes);
        System.out.println(c);
    }
}
