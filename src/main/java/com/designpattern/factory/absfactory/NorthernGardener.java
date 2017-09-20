package com.designpattern.factory.absfactory;

/**
 * Created by lihuiyan on 2017/1/5.
 */
public class NorthernGardener implements Gardener {

    public Fruit createFruit(String name) {
        return new NorthernFruit(name);
    }

    public Veggie createVeggie(String name) {
        return new NorthernVeggie(name);
    }

}
