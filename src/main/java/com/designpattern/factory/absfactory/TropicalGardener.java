package com.designpattern.factory.absfactory;

/**
 * Created by lihuiyan on 2017/1/5.
 */
public class TropicalGardener implements Gardener {

    public Fruit createFruit(String name) {
        return new TropicalFruit(name);
    }

    public Veggie createVeggie(String name) {
        return new TropicalVeggie(name);
    }
}
