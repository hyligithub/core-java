package com.designpattern.factory.simplefactory;

/**
 * Created by lihuiyan on 2016/12/29.
 */
public class Apple implements Fruit {

    private int treeAge;

    @Override
    public void grow() {
        log("apple--grow");
    }

    @Override
    public void plant() {
        log("apple--plant");
    }

    @Override
    public void harvest() {
        log("apple--harvest");
    }

    private void log(String msg) {
        System.out.println(msg);
    }

    public int getTreeAge() {
        return treeAge;
    }

    public void setTreeAge(int treeAge) {
        this.treeAge = treeAge;
    }
}
