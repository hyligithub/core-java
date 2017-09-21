package com.core.thread;

public class ThreadPrioritiesDemo extends Thread {
    private int priority;

    public ThreadPrioritiesDemo(String name, int priority) {
        super(name);
        this.priority = priority;
    }

    public static void main(String[] args) {
        Thread t1 = new ThreadPrioritiesDemo("thread1", 1);
        Thread t2 = new ThreadPrioritiesDemo("thread2", 10);
        t1.start();
        t2.start();
    }

    @Override
    public void run() {
        Thread.currentThread().setPriority(priority);
        for (int i = 0; i < 1000; i++) {
            System.out.println(this + ":" + i);
            if (i % 2 == 0)
                Thread.yield();
        }
    }
}
