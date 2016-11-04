package com.core.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by lihuiyan on 2016/11/2.
 * Condition是对锁更加精细的控制，await()相当于Object的wait()方法，signal()相当于Object的notify()
 * wait()和notify()需要和对象锁捆绑使用的，await()和 signal()是和Lock锁捆绑使用的
 *
 */
public class ConditionExample {
    private static Lock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();

    public static void main(String[] args) {
        ThreadA a = new ThreadA("ta");
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " call a.start");
            a.start();

            System.out.println(Thread.currentThread().getName() + " call condition.await() ");
            condition.await();
            System.out.println(Thread.currentThread().getName() + " continue");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    static class ThreadA extends Thread {

        public ThreadA(String name) {
            super(name);
        }

        @Override
        public void run() {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + " wake up others");
                condition.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }

}
