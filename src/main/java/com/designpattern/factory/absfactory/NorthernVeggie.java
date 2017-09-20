package com.designpattern.factory.absfactory;

/**
 * Created by lihuiyan on 2017/1/5.
 */
public class NorthernVeggie implements Veggie {
    private String name;

    public NorthernVeggie(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
