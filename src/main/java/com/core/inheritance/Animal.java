package com.core.inheritance;

/**
 * Created by lihuiyan on 2016/9/12.
 * 1.is-a 的关系
 * 2.单继承
 * 3.父类如果没有无参构造器，子类必须有无参构造器
 * 4.向上转型、向下转型需要注意实例的类型
 * 5.可以重载父类的方法
 * 6.如果父类不希望被实例化，可以定义为abstract的
 * 7.访问父类的私有变量可以通过get set方法，公有变量可以直接访问
 * 8.少用继承多用组合
 */
public class Animal {

    public Animal(int i) {
        this.noOfLegs = i;
    }

    public int getNoOfLegs() {
        return noOfLegs;
    }

    public void setNoOfLegs(int noOfLegs) {
        this.noOfLegs = noOfLegs;
    }

    private int noOfLegs;
}
