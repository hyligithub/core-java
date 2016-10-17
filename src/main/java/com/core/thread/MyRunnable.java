package com.core.thread;

/**
 * Created by lihuiyan on 2016/10/17.
 */
public class MyRunnable implements Runnable {

    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable());
        thread.start();
    }

    @Override
    public void run() {
        try {
            Thread.sleep(100);
            process();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("this is a my Runnable Ending");
    }

    private void process() throws InterruptedException {
        Thread.sleep(5000);
    }
}
