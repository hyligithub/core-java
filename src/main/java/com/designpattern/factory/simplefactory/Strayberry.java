package com.designpattern.factory.simplefactory;

/**
 * Created by lihuiyan on 2016/12/29.
 */
public class Strayberry implements Fruit {
    @Override
    public void grow() {
        log("Strayberry grow");
    }

    @Override
    public void plant() {
        log("Strayberry plant");
    }

    @Override
    public void harvest() {
        log("Strayberry harvest");
    }

    private void log(String msg) {
        System.out.println(msg);
    }
}
