package com.designpattern.factory.absfactory;

/**
 * Created by lihuiyan on 2017/1/5.
 */
public class TropicalFruit implements Fruit {
    private String name;

    public TropicalFruit(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
