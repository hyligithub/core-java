package com.core.thread.producerconsumer;

/**
 * Created by lihuiyan on 2016/10/24.
 */
public class Consumer {

    private Depot depot;

    public Consumer(Depot depot) {
        this.depot = depot;
    }

    public void consumer(int val) {
        new Thread() {
            @Override
            public void run() {
                depot.consumer(val);
            }
        }.start();
    }
}
