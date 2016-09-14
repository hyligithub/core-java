package com.core.ooc.inheritance;

/**
 * Created by lihuiyan on 2016/9/12.
 */
public class Cat extends Animal {
    public Cat(int i) {
        super(i);
    }

    private int noOfLegs;

    @Override
    public void setNoOfLegs(int i) {
        super.setNoOfLegs(i);
    }
    @Override
    public int getNoOfLegs(){
        return super.getNoOfLegs();
    }

    public void doMemo() {
        System.out.println("cat is memo");
    }

    public void updateNoOfLegs(int i) {
        this.noOfLegs = i;
    }
}
