package com.core.array;

import java.util.Arrays;

/**
 * Created by lihuiyan on 2016/9/17.
 */
public class CopyArrayToArray {

    public static void main(String[] args) {
        Object[] a1 = {"1", "2", "3"};
        Object[] a2 = {"a", "b", "c"};
        Object[] a3 = add(a1, "4");
        System.out.println(Arrays.toString(a3));
        Object[] a4 = add(a2, a3);
        System.out.println(Arrays.toString(a4));
    }

    private static Object[] add(Object[] arr, Object... elements) {
        Object[] tmp = new Object[arr.length + elements.length];
        System.arraycopy(arr, 0, tmp, 0, arr.length);
        for (int i = 0; i < elements.length; i++) {
            tmp[arr.length + i] = elements[i];
        }
        return tmp;
    }
}
