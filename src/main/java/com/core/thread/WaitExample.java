package com.core.thread;


/**
 * Created by lihuiyan on 2016/10/19.
 * 测试wait,notify
 */
public class WaitExample {
    public static void main(String[] args) {
        ThreadA threadA = new ThreadA("a");
        System.out.println(Thread.currentThread().getName() + " start threadA");
        threadA.start();
        synchronized (threadA) {
            try {
                //主线程等待线程a被唤醒
                System.out.println(Thread.currentThread().getName() + " wait()");
                threadA.wait();

                System.out.println(Thread.currentThread().getName() + " continue");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

class ThreadA extends Thread {
    public ThreadA(String name) {
        super(name);
    }

    @Override
    public void run() {
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + " call notify");
            //唤醒阻塞在该对象上的线程
            notify();
        }
    }
}
