package com.core.thread;

/**
 * Created by lihuiyan on 2016/10/20.
 * yield代表线程让步，使线程由运行状态变化为就绪状态，但是并不释放对象锁
 */
public class YieldDemo {

    public static void main(String[] args) {
        MyRunnable2 r = new MyRunnable2();
        Thread t1 = new Thread(r, "t1");
        Thread t2 = new Thread(r, "t2");
        t1.start();
        t2.start();
    }
}

class MyRunnable2 implements Runnable {

    @Override
    public void run() {
        synchronized (this) {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + "--" + i);
                /**
                 * t1,t2在运行时会获取同一个对象锁，
                 * 当取模2为0时，会执行线程让步，但是线程没有释放锁，所以另外一个线程只能等待，直到第一个线程执行完毕才进行
                 */
                if (i % 2 == 0) {
                    Thread.yield();
                }
            }
        }
    }
}