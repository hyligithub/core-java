package com.designpattern.factory.fatorymethod;

import com.designpattern.factory.simplefactory.Fruit;
import com.designpattern.factory.simplefactory.Strayberry;

/**
 * Created by lihuiyan on 2016/12/30.
 */
public class StrayberryGardener implements FruitGardener {
    @Override
    public Fruit foctory() {
        return new Strayberry();
    }
}
