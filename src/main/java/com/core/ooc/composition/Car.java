package com.core.ooc.composition;

/**
 * Created by lihuiyan on 2016/9/9.
 * 组合的优点：1.代码重用，engine这个对象可以被重复引用
 * 2.控制可见性，engine的初始化操作在Car的构造函数中初始化，对客户端来说是不可见的。
 */
public class Car {
    private String color;
    private String type;
    private Engine engine;

    public Car(String color, String type, String power, String typea, String typeb) {
        this.color = color;
        this.type = type;
        this.engine = new Engine();
        engine.setPower(power);
        engine.setTypea(typea);
        engine.setTypeb(typeb);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }
}
