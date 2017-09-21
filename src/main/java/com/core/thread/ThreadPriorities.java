package com.core.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPriorities implements Runnable {

    private int num = 5;
    private volatile double d;
    private int priority;

    public ThreadPriorities(int priority) {
        this.priority = priority;
    }

    public String toString() {
        return Thread.currentThread() + ":" + num;
    }

    @Override
    public void run() {
        Thread.currentThread().setPriority(priority);
        while (true) {
            for (int i = 1; i < 100000; i++) {
                d += (Math.PI + Math.E) / (double) i;
                if (i % 1000 == 0)
                    Thread.yield();
            }
            System.out.println(this);
            if (--num == 0) return;
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new ThreadPriorities(Thread.MIN_PRIORITY));
        }
        executorService.execute(new ThreadPriorities(Thread.MAX_PRIORITY));
    }
}
