package com.core.thread.daemon;


import java.util.concurrent.TimeUnit;

public class DaemonThreadDemo implements Runnable {
    @Override
    public void run() {
        try {
            while (true) {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread().getName() + "**Daemon:" + Thread.currentThread().isDaemon());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(new DaemonThreadDemo(), "thread" + i);
            t.setDaemon(true);//daemon值要在线程启动之前设置
            t.start();
        }
        System.out.println("all daemon thread start");
        TimeUnit.MILLISECONDS.sleep(150);

    }
}
