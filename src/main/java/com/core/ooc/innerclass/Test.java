package com.core.ooc.innerclass;

/**
 * Created by lihuiyan on 2016/9/13.
 */
public class Test {

    public static void main(String[] args) {
        OutClass outClass = new OutClass(1, 2, 3, 4);
        OutClass.StaticNestedClass staticNestedClass = new OutClass.StaticNestedClass();
        OutClass.StaticNestedClass staticNestedClass1 = new OutClass.StaticNestedClass();
        System.out.println(staticNestedClass.getName());
        staticNestedClass.d = 10;
        System.out.println(staticNestedClass.d);
        System.out.println(staticNestedClass1.d);

        OutClass.InnerClass innerClass = outClass.new InnerClass();
        System.out.println(innerClass.getName());
        System.out.println(innerClass);
        innerClass.setValues();
        System.out.println(innerClass);
        outClass.print("Outer");

        outClass.anonymousClassTest();
    }
}
