package com.core.iaa;

/**
 * Created by lihuiyan on 2016/9/14.
 */
public class InterfaceAndAbstractClass extends AbstractClassA {
    public void abstractClassMethod() {
        System.out.println("this is InterfaceAndAbstractClass implement");
    }

    public void print() {
        System.out.print(a);
        System.out.print(b);
        System.out.print(c);
    }

    @Override
    public void subInterfaceMethod() {
        System.out.println("InterfaceAndAbstractClass:abstract class implementation InterfaceA method");
    }

//    @Override
//    public void superInterfaceMethod() {
//        System.out.println("InterfaceAndAbstractClass:abstract class implementation superInterfaceMethod method");
//    }

    public static void main(String[] args){
        SuperInterface s1 = new InterfaceAndAbstractClass();
        s1.superInterfaceMethod();
        InterfaceA s2 = new InterfaceAndAbstractClass();
        s2.superInterfaceMethod();
        s2.subInterfaceMethod();
        AbstractClassA s3 = new InterfaceAndAbstractClass();
        s3.abstractClassMethod();
        s3.print();

    }
}
