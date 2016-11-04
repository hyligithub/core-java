package com.core.juc;

import com.core.PrintUtil;

import java.util.concurrent.CountDownLatch;

/**
 * Created by lihuiyan on 2016/11/4.
 * CountDownLatch是基于共享锁实现的，count数代表有多少个线程可以同时获得锁，当
 * 某线程调用await()方法时，会等待锁可用时才能获取锁，实际是通过state=0来判断
 */
public class CountDownLatchExample {

    private static final int THREAD_SIZE = 5;
    private static CountDownLatch countDownLatch;

    public static void main(String[] args) {
        countDownLatch = new CountDownLatch(THREAD_SIZE);
        for (int i = 0; i < THREAD_SIZE; i++) {
            new ThreadA("ta" + i).start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        PrintUtil.print(Thread.currentThread().getName() + " continue");
    }

    static class ThreadA extends Thread {
        public ThreadA(String name) {
            super(name);
        }

        @Override
        public void run() {
            try {
                PrintUtil.print(Thread.currentThread().getName() + " start");
                Thread.sleep(100);
                PrintUtil.print(Thread.currentThread().getName() + " end");
                countDownLatch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
