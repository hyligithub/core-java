package com.core.thread.producerconsumer;

/**
 * Created by lihuiyan on 2016/10/24.
 */
public class Depot {

    private int capacity;//总容量
    private int size;//实际容量

    public Depot(int val) {
        this.capacity = val;
        this.size = 0;
    }

    public synchronized void produce(int val) {
        int left = val;

        while (left > 0) {
            try {
                while (size >= capacity) {
                    wait();
                }
                int incr = (size + left) > capacity ? capacity - size : left;
                size += incr;
                left -= incr;
                System.out.println("left=" + left + ",size=" + size);
                notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public synchronized void consumer(int val) {
        int left = val;
        while (left > 0) {
            try {
                while (size <= 0) {
                    wait();
                }
                int desc = size - left < 0 ? size : left;
                size -= desc;
                left -= desc;
                System.out.println(Thread.currentThread().getName()+"-->left=" + left + ",size=" + size);
                notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
