package com.designpattern.factory.simplefactory;

/**
 * Created by lihuiyan on 2016/12/29.
 * 简单工厂模式，工厂类是核心，创建所有商品，不符合开闭原则
 */
public class FruitGardener {
    public static void main(String[] args) {
        try {
            Fruit apple = fruitFacoty("apple");
            Fruit grape = fruitFacoty("grape");
            Fruit strayberry = fruitFacoty("123");
            apple.grow();
            grape.plant();
            strayberry.harvest();

        } catch (BadFruitException e) {
            e.printStackTrace();
        }
    }

    private static Fruit fruitFacoty(String which) throws BadFruitException {
        if ("apple".equals(which)) {
            return new Apple();
        } else if ("grape".equals(which)) {
            return new Grape();
        } else if ("strayberry".equals(which)) {
            return new Strayberry();
        } else
            throw new BadFruitException("bad fruit request");
    }
}
