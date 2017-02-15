package com.designpattern.factory.fatorymethod;

import com.designpattern.factory.simplefactory.Fruit;
import com.designpattern.factory.simplefactory.Grape;

/**
 * Created by lihuiyan on 2016/12/30.
 */
public class GrapeGardener implements FruitGardener {
    @Override
    public Fruit foctory() {
        return new Grape();
    }
}
