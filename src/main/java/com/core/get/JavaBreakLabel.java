package com.core.get;

/**
 * Created by lihuiyan on 2016/9/9.
 */
public class JavaBreakLabel {

    public static void main(String[] args) {
        int a[][] = {{1, 2}, {3, 4}, {9, 10}, {11, 12}};
        boolean flag = false;
        int row, col = 0;
        searchint:
        for (row = 0; row < a.length; row++) {
            for (col = 0; col < a[row].length; col++) {
                if (a[row][col] > 10) {
                    flag = true;
                    break searchint;
                }
            }
        }
        if (flag) {
            System.out.println("the first index is " + row);
        }
        switch_beak();
    }

    public static void switch_beak() {
        int i = 2;
        switch (i) {
            case 1:
                System.out.println("A");
                break;
            case 2:
                System.out.println("B");
                break;
            case 3:
                System.out.println("C");
                break;
            default:
                System.out.println("default");
        }
    }
}
