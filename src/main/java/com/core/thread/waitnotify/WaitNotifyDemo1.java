package com.core.thread.waitnotify;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author Andy
 * @Date 2017/11/11 21:09.
 */
public class WaitNotifyDemo1 {

    public static void main(String[] args) {
        final Queue queue = new LinkedList<>();
        Thread producer = new Producer("producer", queue);
        Thread consumer = new Consumer("consumer", queue);
        producer.start();
        consumer.start();
    }
}


