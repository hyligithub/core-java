package com.core.dto.datatypes;

/**
 * Created by lihuiyan on 2016/9/14.
 */
public class DataTypes {

    public static void main(String[] args) {
        char c = 'A';
        System.out.println(c);
        char c1 = '\u0041';
        System.out.println(c1);
        char c2 = 0;
        System.out.println(c2);
        char c3 = 65;
        System.out.println(c3);

        char c4 = '\t';
        System.out.println(c4);

        byte b = 10;
        System.out.println(b);
        byte b1 = (byte) 200;
        System.out.println(b1);

        short s = 32;
        short s1 = 'A';
        System.out.println(s1);

        byte x, y = 1, z = 2;
        x = (byte) (y + z);
    }
}
