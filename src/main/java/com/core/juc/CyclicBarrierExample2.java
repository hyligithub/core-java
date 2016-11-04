package com.core.juc;

import com.core.PrintUtil;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by lihuiyan on 2016/11/4.
 */
public class CyclicBarrierExample2 {
    private static final int BARRIER_SIZE = 5;
    private static CyclicBarrier cyclicBarrier;

    public static void main(String[] args) {
        cyclicBarrier = new CyclicBarrier(BARRIER_SIZE, new Runnable() {
            @Override
            public void run() {
                PrintUtil.print(Thread.currentThread().getName());
            }
        });
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
            try {
                PrintUtil.print(Thread.currentThread().getName() + " start");
                cyclicBarrier.await();
                PrintUtil.print(Thread.currentThread().getName() + " end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

}
