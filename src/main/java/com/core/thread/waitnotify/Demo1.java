package com.core.thread.waitnotify;

public class Demo1 {
    private static String msg;

    public static void main(String[] args) {
        work();
    }

    public static void work() {
        Thread t1 = new Thread(() -> {
            while (msg == null) {
            }
            System.out.println(msg + "!!!");
        });

        Thread t2 = new Thread(() -> {
            msg = "t2 set the msg";
        });

        t1.start();
        t2.start();
    }
}
