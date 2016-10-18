package com.core.thread;

/**
 * Created by lihuiyan on 2016/10/17.
 */
public class MyRunnable implements Runnable {

    private int ticket = 10;

    public static void main(String[] args) {
        Runnable runnable = new MyRunnable();
        //runnable 可以实现资源共享,下面3个线程共享一个runnable,一共卖了10张票
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        Thread t3 = new Thread(runnable);
        t1.start();
        t2.start();
        t3.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if (this.ticket > 0) {
                System.out.println(Thread.currentThread().getName() + ",ticket:" + ticket--);
            }
        }
    }

}
