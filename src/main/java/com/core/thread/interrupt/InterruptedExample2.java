package com.core.thread.interrupt;

import java.util.concurrent.TimeUnit;

/**
 * @Author Andy
 * @Date 2017/10/31 10:32.
 */
public class InterruptedExample2 {

    public static void main(String[] args) {
        try {
            Thread t1 = new Thread(new TaskRunnable(), "t1");
            t1.start();
            TimeUnit.MILLISECONDS.sleep(100);
            t1.interrupt();
            System.out.println("ending");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


class TaskRunnable implements Runnable {
    @Override
    public void run() {
        int i = 0;
        while (!Thread.currentThread().isInterrupted()) {
            try {
                System.out.println(++i);
                Thread.sleep(300);
            } catch (InterruptedException e) {
                System.out.println("catch the InterruptedException");
                Thread.currentThread().interrupt();
            }
        }
    }
}
