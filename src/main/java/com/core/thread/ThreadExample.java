package com.core.thread;

/**
 * Created by lihuiyan on 2017/3/14.
 */
public class ThreadExample extends Thread {

    private int num = 10;

    public static void main(String[] args) {
        ThreadExample t1 = new ThreadExample();
        ThreadExample t2 = new ThreadExample();
        ThreadExample t3 = new ThreadExample();
        t1.start();
        t2.start();
        t3.start();
    }

    public void run() {
        for (int i = 0; i < 20; i++) {
            if (num > 0) {
                System.out.println(Thread.currentThread().getName()+"---"+num--);
            }
        }
    }
}
