package com.core;

import java.util.concurrent.TimeUnit;

/**
 * @Author Andy
 * @Date 2017/10/16 16:19.
 */
public class SynchronizedExample {

    public static void main(String[] args) throws InterruptedException {
        Runnable r = new MyRunnable();
        Thread t1 = new Thread(r, "t1");
        Thread t2 = new Thread(r, "t2");
        t1.start();
        t2.start();

        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println("分割线---------");

        Thread thread1 = new MyThread("thread1");
        Thread thread2 = new MyThread("thread2");
        thread1.start();
        thread2.start();
    }

}

class MyRunnable implements Runnable {

    @Override
    public void run() {
        synchronized (this) {
            try {

                for (int i = 0; i < 4; i++) {
                    TimeUnit.MILLISECONDS.sleep(10);
                    System.out.println(Thread.currentThread().getName() + "--" + i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        synchronized (this) {
            try {

                for (int i = 0; i < 5; i++) {
                    TimeUnit.MILLISECONDS.sleep(10);
                    System.out.println(Thread.currentThread().getName() + "--" + i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
