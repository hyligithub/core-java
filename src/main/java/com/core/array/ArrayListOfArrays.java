package com.core.array;

import java.util.ArrayList;

/**
 * Created by lihuiyan on 2016/9/17.
 */
public class ArrayListOfArrays {

    public static void main(String[] args) {
        ArrayListOfString();
        ArrayListOfObjects();
    }

    private static void ArrayListOfString() {
        String[] a = {"a", "b", "c"};
        String[] b = {"1", "2", "3"};
        ArrayList<String[]> arrayListString = new ArrayList<String[]>();
        arrayListString.add(a);
        arrayListString.add(b);
        for (String[] s : arrayListString) {
            for (String s1 : s) {
                System.out.println(s1);
            }
        }
    }

    private static void ArrayListOfObjects() {
        String[] c = {"1", "q", "a", "z"};
        ArrayListOfArrays arrayListOfArrays = new ArrayListOfArrays();
        ArrayListOfArrays.A[] aa = {arrayListOfArrays.new A("A", 22), arrayListOfArrays.new A("B", 66)};
        ArrayList<Object[]> arrayList = new ArrayList<Object[]>();
        arrayList.add(c);
        arrayList.add(aa);
        for (Object[] o : arrayList) {
            for (Object o1 : o) {
                if (o1 instanceof String) {
                    System.out.println(o1.toString());
                } else if (o1 instanceof A) {
                    System.out.println(((A) o1).getAge() + "--" + ((A) o1).getName());
                }
            }
        }

    }

    public class A {
        private String name;
        private int age;

        public A(String name, int age) {
            this.age = age;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }
}
