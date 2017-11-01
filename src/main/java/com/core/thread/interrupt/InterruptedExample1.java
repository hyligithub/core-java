package com.core.thread.interrupt;

/**
 * @Author Andy
 * @Date 2017/10/31 8:32.
 */
public class InterruptedExample1 {

    public static void main(String[] args) {
        Thread t1 = new MyThread("t1");
        t1.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.interrupt();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "--"
                + t1.getName() + "--" + t1.getState() + "--" + t1.isInterrupted());
    }

    public static void test() throws InterruptedException {
        Thread.currentThread().wait();
    }
}

class MyThread extends Thread {

    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        int i = 0;
        try {
            while (true) {
                System.out.println(++i);
                sleep(100);
            }
        } catch (InterruptedException e) {
            System.out.println("catch InterruptedException");
            System.out.println(getName() + "--" + getState() + "--" + isInterrupted());
            Thread.currentThread().interrupt();
            System.out.println(getName() + "--" + getState() + "--" + isInterrupted());
        }
    }
}

