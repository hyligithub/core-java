package com.core.thread;

/**
 * Created by lihuiyan on 2016/10/20.
 * join：让主线程等待子线程执行结束后再继续执行
 */
public class JoinExample {

    public static void main(String[] args) {
        MyThread threadA = new MyThread("t1");
        System.out.println(Thread.currentThread().getName() + " start t1");
        threadA.start();
        try {
            System.out.println(Thread.currentThread().getName() + " call thread.join()");
            threadA.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " continue");
    }

    static class MyThread extends Thread {
        public MyThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + "---" + i);
            }
        }

    }
}
