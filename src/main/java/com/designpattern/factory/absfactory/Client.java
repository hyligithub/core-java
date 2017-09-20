package com.designpattern.factory.absfactory;

/**
 * Created by lihuiyan on 2017/1/3.
 */
public class Client {

    public static void main(String[] args) {
        ConcreteCreator1 c1 = new ConcreteCreator1();
        ConcreteCreator2 c2 = new ConcreteCreator2();
        ProductA pa1 = c1.createProductA();
        ProductA pa2 = c2.createProductA();
        ProductB pb1 = c1.createProductB();
        ProductB pb2 = c2.createProductB();
    }
}
