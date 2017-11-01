package com.core.thread.interrupt;

/**
 * @Author Andy
 * @Date 2017/11/1 12:39.
 */
public class InterruptedExample4 {
    private static final Object o = new Object();

    public static void test() {
        int i = 0;
        synchronized (o) {
            while (i < 5) {
                System.out.println(i++);
                Thread.yield();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
//        test();
        Thread t1 = new Thread(new MyRunnable2(o), "t1");
        t1.start();
        Thread.sleep(4);
        t1.interrupt();
    }
}

class MyRunnable2 implements Runnable {

    private Object o;

    public MyRunnable2(Object o) {
        this.o = o;
    }

    @Override
    public void run() {
        while(!Thread.currentThread().isInterrupted()) {
            synchronized (o) {
                System.out.println("get the lock do something");
            }
        }
    }
}
