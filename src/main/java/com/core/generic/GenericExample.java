package com.core.generic;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lihuiyan on 2016/10/11.
 */
public class GenericExample {

    public static void main(String[] args) {
        genericOrNotGeneric();
        genericAtCompileTime();
        genericClassAndCommonClass();
        wildCard();
    }

    /**
     * 使用泛型和不使用泛型的区别
     */
    private static void genericOrNotGeneric() {
        List list = new ArrayList();//没有使用泛型,list中对象的类型默认为Object,所以可以加入任何类型，编译时没有问题
        list.add("this is a String");
        list.add(1);
        for (int i = 0; i < list.size(); i++) {
//            String name = (String) list.get(i);//运行时,在list遍历的时候，不知道里面具体的类型是什么，如果强制转换，就会抛异常
        }
        /**
         * 为了解决上面的问题，出现了泛型，容器中指定了具体的类型，实现了编译期检查
         * 下面的list只能存储String类型的对象
         */
        List<String> listStr = new ArrayList();
        listStr.add("this is a String list");
        listStr.add("this is a str");
        //listStr.add(1);//编译时就会报错
        for (String str : listStr) {
            System.out.println(str);
        }
    }

    /**
     * 泛型只在编译时起作用,运行时会泛型擦除
     */
    private static void genericAtCompileTime() {
        List<String> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        //反射都是发生在运行时，结果clazz1==clazz2,说明泛型只有在编译期起作用，在运行时会去泛型化(泛型擦除)
        Class clazz1 = list.getClass();
        Class clazz2 = list1.getClass();
        System.out.println(clazz1 == clazz2);//true

        //下面验证了泛型擦除
        List<String> list2 = new ArrayList<>();//定义了泛型list，只能存储String类型对象
        list2.add("this is a String");
        Class clazz = list2.getClass();
        try {
            Method method = clazz.getMethod("add", Object.class);
            //反射都是发生在运行时，通过反射，向list2中添加了Integer类型的对象
            method.invoke(list2, 100);
            //list2结果：[this is a String, 100]
            System.out.println(list2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 通配符
     */
    private static void wildCard() {
        List<Number> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        //list = list1;// error 虽然Integer是Number的子类，但是List<Integer>不是List<Number>的子类型
        List<?> list3 = new ArrayList<>();//这种方式参数类型只要是Object就可以
        list3 = list1;
        list3 = list;

        Bar<Integer> bar = new Bar<>(12345);
//        showData(bar);//showData(Bar<?> bar)才OK
        extendsO(bar);

        Bar<Double> bar1 = new Bar<>(123.123);
        extendsO(bar1);
    }

    private static void showData(Bar<Number> bar) {
        bar.showType();
    }

    /**
     * 上界
     *
     * @param bar
     */
    private static void extendsO(Bar<? extends Number> bar) {
        bar.showType();
    }

    /**
     * 泛型类和非泛型类的使用区别
     */
    private static void genericClassAndCommonClass() {
        Foo foo = new Foo(new String("this is a common class"));
        System.out.println(foo.getObject());
        foo.showType();
        Foo foo1 = new Foo(new Integer(199));
        foo1.showType();
        System.out.println("-----common class end----------");

        System.out.println("-----generic class start----------");
        Bar<String> bar = new Bar<>("this is a generic class");
        bar.showType();

        Bar<Integer> bar1 = new Bar<>(1);
        bar1.showType();
    }

    /**
     * 定义非泛型类
     */
    static class Foo {
        private Object object;//定义泛型成员变量

        public Foo(Object o) {
            this.object = o;
        }

        public Object getObject() {
            return object;
        }

        public void showType() {
            System.out.println("对象的实际类型是：" + object.getClass().getName());
        }
    }

    /**
     * 定义泛型类
     *
     * @param <T>
     */
    static class Bar<T> {
        private T value;

        public Bar(T t) {
            value = t;
        }

        public T getValue() {
            return value;
        }

        public void showType() {
            System.out.println("T的实际类型是:" + value.getClass().getName());
        }
    }
}
