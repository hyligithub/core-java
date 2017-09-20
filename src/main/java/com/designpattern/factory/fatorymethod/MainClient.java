package com.designpattern.factory.fatorymethod;

import com.designpattern.factory.simplefactory.Fruit;

/**
 * Created by lihuiyan on 2016/12/30.
 * 工厂方法模式，具体的工厂创建具体的产品，符合开闭原则
 */
public class MainClient {

    public static void main(String[] args) {
        Fruit apple = new AppleGardener().foctory();
        Fruit grape = new GrapeGardener().foctory();
        Fruit strayberry = new StrayberryGardener().foctory();

        apple.grow();
        grape.harvest();
        strayberry.harvest();
    }
}
