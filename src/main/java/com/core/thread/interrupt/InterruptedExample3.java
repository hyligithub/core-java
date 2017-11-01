package com.core.thread.interrupt;

import java.util.concurrent.TimeUnit;

/**
 * @Author Andy
 * @Date 2017/11/1 9:29.
 */
public class InterruptedExample3 {

    public static void main(String[] args) {
        Thread t1 = new MyThread1("t1");
        t1.start();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.interrupt();
    }

}

class MyThread1 extends Thread {
    public MyThread1(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (true) {
            if (isInterrupted()) {
                System.out.println("isInterrupted is true");
            } else {
                System.out.println(" isInterrupted is false");
            }
        }
    }
}
