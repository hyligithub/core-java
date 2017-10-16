package com.core;

import java.util.concurrent.TimeUnit;

/**
 * @Author Andy
 * @Date 2017/10/16 18:12.
 */
public class SynchronizedExample3 {
    public static void main(String[] args) {
        method();
    }

    public static void method() {
        SynchronizedExample3 se = new SynchronizedExample3();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                se.syncMethod1();
            }
        }, "t1");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                se.syncMethod2();
            }
        }, "t2");
        t1.start();
        t2.start();
    }


    public void syncMethod1() {
        synchronized (this) {
            try {
                for (int i = 0; i < 5; i++) {
                    TimeUnit.MILLISECONDS.sleep(50);
                    System.out.println(Thread.currentThread().getName() + "--syncMethod1--" + i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void syncMethod2() {
        synchronized (this) {
            try {
                for (int i = 0; i < 5; i++) {
                    TimeUnit.MILLISECONDS.sleep(50);
                    System.out.println(Thread.currentThread().getName() + "--syncMethod2--" + i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
