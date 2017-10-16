package com.core;

import java.util.concurrent.TimeUnit;

public class SynchronizedExample5 {
    public static void main(String[] args) {
        SynchronizedExample5 se = new SynchronizedExample5();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                method1();
            }
        }, "t1");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                se.method2();
            }
        }, "t2");
        t1.start();
        t2.start();
    }

    public static synchronized void method1() {
        try {
            for (int i = 0; i < 5; i++) {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread().getName() + "--method1--" + i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void method2() {
        synchronized (this) {
            try {
                for (int i = 0; i < 5; i++) {
                    TimeUnit.MILLISECONDS.sleep(100);
                    System.out.println(Thread.currentThread().getName() + "--method2--" + i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
