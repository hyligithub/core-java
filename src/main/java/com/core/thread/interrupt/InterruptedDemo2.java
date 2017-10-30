package com.core.thread.interrupt;

/**
 * @Author Andy
 * @Date 2017/10/30 17:30.
 */
public class InterruptedDemo2 {
    public static void test() throws InterruptedException {
        Thread t1 = new Thread(new MyRunnable(), "t1");
        t1.start();
        Thread.sleep(30);
        t1.interrupt();
        Thread.sleep(30);
        System.out.println(t1.isInterrupted() + "---");

    }

    public static void main(String[] args) throws InterruptedException {
        test();
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        int i = 0;
        try {
            while (true) {

                Thread.sleep(100);
                System.out.println(++i);
            }
        } catch (InterruptedException e) {
            System.out.println("aaa");
            Thread.currentThread().interrupt();
            System.out.println(Thread.currentThread().getName());
        }
    }
}

