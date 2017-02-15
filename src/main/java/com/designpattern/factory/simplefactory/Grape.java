package com.designpattern.factory.simplefactory;

/**
 * Created by lihuiyan on 2016/12/29.
 */
public class Grape implements Fruit {
    /*
    有籽无籽
     */
    private boolean seedLess;

    @Override
    public void grow() {
        log("grape grow");
    }

    @Override
    public void plant() {
        log("grape plant");
    }

    @Override
    public void harvest() {
        log("grape harvest");
    }

    private void log(String msg) {
        System.out.println(msg);
    }

    public boolean isSeedLess() {
        return seedLess;
    }

    public void setSeedLess(boolean seedLess) {
        this.seedLess = seedLess;
    }
}
