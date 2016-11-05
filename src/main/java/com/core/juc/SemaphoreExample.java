package com.core.juc;

import com.core.PrintUtil;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by lihuiyan on 2016/11/5.
 */
public class SemaphoreExample {
    private static final int SEM_MAX = 10;

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(SEM_MAX);
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(new ThreadA(semaphore, 5));
        executorService.submit(new ThreadA(semaphore, 4));
        executorService.submit(new ThreadA(semaphore, 7));
        executorService.shutdown();
    }

    static class ThreadA extends Thread {
        private volatile Semaphore semaphore;
        private int count;//申请许可数

        public ThreadA(Semaphore semaphore, int count) {
            this.semaphore = semaphore;
            this.count = count;
        }

        @Override
        public void run() {
            try {
                PrintUtil.print(Thread.currentThread().getName());
                semaphore.acquire(count);
                Thread.sleep(200);
                PrintUtil.print(Thread.currentThread().getName() + " accquire= " + count);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release(count);
                PrintUtil.print(Thread.currentThread().getName() + " release=" + count);
            }
        }
    }
}
