package com.core.iaa;

/**
 * Created by lihuiyan on 2016/9/14.
 */
public abstract class AbstractClassA implements InterfaceA {

    public AbstractClassA() {
    }

    public void print() {
        System.out.print(a);
        System.out.print(b);
        System.out.print(c);
        System.out.println("this is abstract class method print");
    }

    public void subInterfaceMethod() {
        System.out.println("abstract class implementation InterfaceA method");
    }

    public void superInterfaceMethod() {
        System.out.println("abstract class implementation superInterfaceMethod method");
    }

    public abstract void abstractClassMethod();
}
