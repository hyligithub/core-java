package com.core.inheritance;

/**
 * Created by lihuiyan on 2016/9/12.
 */
public class Test {
    public static void main(String[] args) {
        Cat cat = new Cat(4);
        cat.setNoOfLegs(5);
        System.out.println(cat.getNoOfLegs());
        cat.updateNoOfLegs(3);
        int num = cat.getNoOfLegs();
        System.out.println(num);
        Dog dog = new Dog(4);

        Animal a = cat;//upcasting
        Cat c = (Cat) a;//downcasting
//        // a 实际是cat
//        dog = (Dog) a;//ClassCastException
//        Animal a1 = new Animal(2);
//        //a1是animal
//        Cat c1 = (Cat) a1;//ClassCastException
    }
}
