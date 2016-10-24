package com.core.thread.producerconsumer;

/**
 * Created by lihuiyan on 2016/10/24.
 */
public class TestMain {

    public static void main(String[] args) {
        Depot depot = new Depot(100);
        Producer producer = new Producer(depot);
        Consumer consumer = new Consumer(depot);
        producer.produce(110);
        consumer.consumer(30);

    }
}
