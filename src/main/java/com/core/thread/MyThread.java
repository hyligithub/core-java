package com.core.thread;

import com.core.enumexample.ThreadStateEnum;

/**
 * Created by lihuiyan on 2016/10/17.
 */
public class MyThread extends Thread {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getThreadGroup().getName());

        Thread thread = new MyThread("myThread");
        thread.start();
    }

    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getThreadGroup().getName());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("this ia my thread end");
    }

}
