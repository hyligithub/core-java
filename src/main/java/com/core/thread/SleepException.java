package com.core.thread;

public class SleepException implements Runnable {
    @Override
    public void run() {
        throw new RuntimeException("this is RuntimeException");
    }

    public static void main(String[] args) {
        try {
            Thread t = new Thread(new SleepException(), "t1");
            t.start();
        } catch (Exception e) {
            System.out.println("catch a runtime exception");
        }

    }
}
