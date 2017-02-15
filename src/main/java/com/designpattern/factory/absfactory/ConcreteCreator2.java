package com.designpattern.factory.absfactory;

/**
 * Created by lihuiyan on 2017/1/3.
 */
public class ConcreteCreator2 implements Creator {
    @Override
    public ProductA createProductA() {
        return new ProductA2();
    }

    @Override
    public ProductB createProductB() {
        return new ProductB2();
    }
}
