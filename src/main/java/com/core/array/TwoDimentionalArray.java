package com.core.array;

/**
 * Created by lihuiyan on 2016/9/17.
 */
public class TwoDimentionalArray {

    public static void main(String[] args) {
        int[][] a = new int[2][3];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = j;
//                System.out.println(j);
            }
        }

        int[][] b = {{1, 2}, {3, 4, 5}};
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                System.out.println(b[i][j]);
            }
        }
    }
}
