package com.core.thread;

/**
 * @Author Andy
 * @Date 2017/10/12 9:44.
 */
public class SynchronizedDemo1 {

    public synchronized void test1() {
        System.out.println("this is a synchronized method");
    }

    public void test2() {
        synchronized (this) {
            System.out.println("this is a synchronized block");
        }
    }

    public synchronized static void test3(){
        System.out.println("this is a Class Synchronized");
    }
    public static void main(String[] args) {
        SynchronizedDemo1 s1 = new SynchronizedDemo1();
        s1.test1();
        s1.test2();
        test3();
    }
}
