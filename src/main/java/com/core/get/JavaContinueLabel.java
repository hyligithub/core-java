package com.core.get;

/**
 * Created by lihuiyan on 2016/9/9.
 */
public class JavaContinueLabel {

    public static void main(String[] args) {
        String[] array = {"2", "3", "4", "5"};
        processArray(array, "2");
    }

    private static void processArray(String[] array, String a) {
        for (String s : array) {
            if (s.equals(a)) {
                continue;
            }
            System.out.println(s);
        }
    }
}
