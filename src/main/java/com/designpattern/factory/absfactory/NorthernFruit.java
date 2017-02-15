package com.designpattern.factory.absfactory;

/**
 * Created by lihuiyan on 2017/1/5.
 */
public class NorthernFruit implements Fruit {
    private String name;

    public NorthernFruit(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
