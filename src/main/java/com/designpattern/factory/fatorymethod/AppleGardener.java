package com.designpattern.factory.fatorymethod;

import com.designpattern.factory.simplefactory.Apple;
import com.designpattern.factory.simplefactory.Fruit;

/**
 * Created by lihuiyan on 2016/12/30.
 */
public class AppleGardener implements FruitGardener {
    @Override
    public Fruit foctory() {
        return new Apple();
    }
}
