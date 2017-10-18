package com.core.thread;

/**
 * Created by lihuiyan on 2016/10/20.
 * yield代表线程让步，使线程由运行状态变化为就绪状态，但是并不释放对象锁
 */
public class YieldExample {
    private static Object object = new Object();

    public static void main(String[] args) {
        ThreadA t1 = new ThreadA("t1");
        ThreadA t2 = new ThreadA("t2");
        t1.start();
        t2.start();
    }

    static class ThreadA extends Thread {
        public ThreadA(String name) {
            super(name);
        }

        @Override
        public void run() {
            //获取object对象锁
            synchronized (object) {
                for (int i = 0; i < 5; i++) {
                    System.out.println(Thread.currentThread().getName() + "--" + i);
                    /**
                     * t1,t2在运行时会获取同一个对象锁，
                     * 当取模2为0时，会执行线程让步，但是线程没有释放锁，所以另外一个线程只能等待，直到第一个线程执行完毕才进行
                     */

                    if (i % 2 == 0) {
                        yield();
                    }
                }
            }
        }
    }
}
