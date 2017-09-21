package com.core.thread.daemon;

import java.util.concurrent.TimeUnit;

public class DaemonThreadDemo2 implements Runnable {
    private int num = 0;

    public void run() {
        while (true) {
            Thread t = new Thread("thread" + num++);
            System.out.println(t.getName() + ":" + t.isDaemon());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new DaemonThreadDemo2(), "I am a daemon thread");
        t.setDaemon(true);//daemon值要在线程启动之前设置
        t.start();
        TimeUnit.MILLISECONDS.sleep(50);

    }
}
