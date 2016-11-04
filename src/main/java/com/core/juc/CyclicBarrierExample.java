package com.core.juc;

import com.core.PrintUtil;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by lihuiyan on 2016/11/4.
 * 通过独占锁和condition实现，所有线程相互等待，当线程都到达屏障点时，最后一个
 * 到达的线程会触发任务执行
 */
public class CyclicBarrierExample {
    private static final int BARRIER_SIZE = 5;
    private static CyclicBarrier cyclicBarrier;

    public static void main(String[] args) {
        cyclicBarrier = new CyclicBarrier(BARRIER_SIZE);
        for (int i = 0; i < BARRIER_SIZE; i++) {
            new ThreadA("ta" + i).start();
        }
    }

    static class ThreadA extends Thread {
        public ThreadA(String name) {
            super(name);
        }

        @Override
        public void run() {
            PrintUtil.print(Thread.currentThread().getName() + " wait for barrier");
            try {
                Thread.sleep(100);
                cyclicBarrier.await();
                PrintUtil.print(Thread.currentThread().getName() + " continue");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}
