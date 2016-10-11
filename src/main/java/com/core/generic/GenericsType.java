package com.core.generic;

/**
 * Created by lihuiyan on 2016/10/11.
 */
public class GenericsType<T> {
    //编译期检查,运行时不会抛出类型转换错误
    public static void main(String[] args) {
        GenericsType<String> g1 = new GenericsType<>();
        g1.setT("str");
        //这种方式不建议用，T实际上上Object,有可能发生类型转换错误
        GenericsType g2 = new GenericsType();
        g2.setT(1);
        g2.setT(1.1);
        System.out.println(g2.getT());
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    private T t;
}
