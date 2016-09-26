package com.core.comparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by lihuiyan on 2016/9/26.
 */
public class ComparableExample {
    public static void main(String[] args) {
        sortInt();
        sortString();
        sortList();
        sortObject();
        sortByComparator();
    }

    private static void sortInt() {
        int[] array = {2, 4, 6, 1, 9};
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void sortString() {
        String[] array = {"a", "e", "i", "o", "u"};
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void sortList() {
        List<String> list = new ArrayList();
        list.add("A");
        list.add("W");
        list.add("a");
        list.add("e");
        list.add("E");
        Collections.sort(list);
        System.out.println(list.toString());
    }

    private static void sortObject() {
        Employee[] employees = new Employee[4];
        employees[0] = new Employee(1, "张三", 21, 1100);
        employees[1] = new Employee(2, "李四", 25, 2100);
        employees[2] = new Employee(3, "王五", 31, 3100);
        employees[3] = new Employee(4, "赵八", 41, 9100);
        Arrays.sort(employees);//employee必须实现comparable，否则抛异常
        System.out.println(Arrays.toString(employees));
    }

    private static void sortByComparator() {
        Employee[] employees = new Employee[4];
        employees[0] = new Employee(1, "张三", 21, 2100);
        employees[1] = new Employee(2, "李四", 15, 3100);
        employees[2] = new Employee(3, "王五", 31, 1100);
        employees[3] = new Employee(4, "赵八", 17, 9100);
        Arrays.sort(employees, Employee.comparatorByAge);
        System.out.println(Arrays.toString(employees));
        System.out.println("***********");
        Arrays.sort(employees, Employee.comparatorById);
        System.out.println(Arrays.toString(employees));
        System.out.println("***********");
        Arrays.sort(employees, Employee.comparatorBySalary);
        System.out.println(Arrays.toString(employees));
        System.out.println("***********");
        Arrays.sort(employees, Employee.comparatorByName);
        System.out.println(Arrays.toString(employees));
    }
}
