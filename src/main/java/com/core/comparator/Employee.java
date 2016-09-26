package com.core.comparator;

import java.util.Comparator;

/**
 * Created by lihuiyan on 2016/9/26.
 * 实现comparable可以实现单一属性的排序，如果需求有变动，就需要修改pojo代码
 * 不符合开闭原则
 * 所以最好通过comparator实现排序
 */
public class Employee implements Comparable<Employee> {

    public Employee(int id, String name, int age, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "id=" + id + ",name=" + name + ",age=" + age + ",salary=" + salary;
    }

    private int id;
    private String name;
    private int age;
    private double salary;

    @Override
    public int compareTo(Employee o) {
        return this.getId() - o.getId();
    }

    public static Comparator<Employee> comparatorById = new Comparator<Employee>() {
        @Override
        public int compare(Employee o1, Employee o2) {
            return o1.getId() - o2.getId();
        }
    };

    public static Comparator<Employee> comparatorByName = new Comparator<Employee>() {
        @Override
        public int compare(Employee o1, Employee o2) {
            return o1.getName().compareTo(o2.getName());
        }
    };

    public static Comparator<Employee> comparatorBySalary = new Comparator<Employee>() {
        @Override
        public int compare(Employee o1, Employee o2) {
            return (int) (o1.getSalary() - o2.getSalary());
        }
    };

    public static Comparator<Employee> comparatorByAge = new Comparator<Employee>() {
        @Override
        public int compare(Employee o1, Employee o2) {
            return o1.getAge() - o2.getAge();
        }
    };

}
