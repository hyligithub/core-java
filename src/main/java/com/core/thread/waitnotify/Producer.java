package com.core.thread.waitnotify;

import java.util.Queue;

/**
 * @Author Andy
 * @Date 2017/11/13 17:09.
 */
public class Producer extends Thread {

    private final Queue sharedQueue;

    public Producer(String name, Queue queue) {
        super(name);
        this.sharedQueue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 10; i++) {
            synchronized (sharedQueue) {
                while (sharedQueue.size() == 10) {
                    try {
                        sharedQueue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                sharedQueue.add(i);
                System.out.println("producer " + i);
                sharedQueue.notify();
            }
        }
    }

}
