package com.core.thread;

/**
 * Created by lihuiyan on 2016/10/19.
 */
public class NotifyAllTest {
    final static Object object = new Object();

    public static void main(String[] args) {
        ThreadB t1 = new ThreadB("t1");
        ThreadB t2 = new ThreadB("t2");
        ThreadB t3 = new ThreadB("t3");
        t1.start();
        t2.start();
        t3.start();
        try {
            System.out.println(Thread.currentThread().getName() + " sleep(300)");
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (object) {
            System.out.println(Thread.currentThread().getName() + " call notifyAll()");
            object.notifyAll();
        }
    }

    static class ThreadB extends Thread {
        public ThreadB(String name) {
            super(name);
        }

        @Override
        public void run() {
            synchronized (object) {
                System.out.println(Thread.currentThread().getName() + " wait()");
                try {
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " continue");
            }
        }
    }
}


