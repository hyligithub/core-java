package com.core.thread.waitnotify;

import java.util.Queue;

/**
 * @Author Andy
 * @Date 2017/11/13 17:15.
 */
public class Consumer extends Thread {
    private final Queue sharedQueue;

    public Consumer(String name, Queue queue) {
        super(name);
        this.sharedQueue = queue;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (sharedQueue) {
                while (sharedQueue.size() == 0) {
                    try {
                        sharedQueue.wait();
                        sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Integer o = (Integer) sharedQueue.poll();
                sharedQueue.notify();
                if (o == 10) {
                    break;
                }
            }
        }
    }
}
