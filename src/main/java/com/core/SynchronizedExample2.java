package com.core;

import java.util.concurrent.TimeUnit;

/**
 * @Author Andy
 * @Date 2017/10/16 18:02.
 */
public class SynchronizedExample2 {
    public static void main(String[] args) {
        method();
    }

    public static void method() {
        SynchronizedExample2 se = new SynchronizedExample2();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                se.syncMethod();
            }
        }, "t1");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                se.nonSyncMethod();
            }
        }, "t2");
        t1.start();
        t2.start();
    }


    public void syncMethod() {
        synchronized (this) {
            try {
                for (int i = 0; i < 5; i++) {
                    TimeUnit.MILLISECONDS.sleep(50);
                    System.out.println(Thread.currentThread().getName() + "--syncMethod--" + i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void nonSyncMethod() {
        try {
            for (int i = 0; i < 5; i++) {
                TimeUnit.MILLISECONDS.sleep(50);
                System.out.println(Thread.currentThread().getName() + "--nonSyncMethod--" + i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
