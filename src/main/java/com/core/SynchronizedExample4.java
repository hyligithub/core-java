package com.core;

import java.util.concurrent.TimeUnit;

public class SynchronizedExample4 {

    public static void main(String[] args) {
        test();
    }

    public static void test() {
        Thread t1 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        syncMethod1();
                    }
                }, "t1");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                syncMethod2();
            }
        }, "t2");
        t1.start();
        t2.start();
    }

    public static synchronized void syncMethod1() {
        for (int i = 0; i < 5; i++) {
            try {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread().getName() + "--syncMethod1--" + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static synchronized void syncMethod2() {
        for (int i = 0; i < 5; i++) {
            try {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread().getName() + "--syncMethod2--" + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
