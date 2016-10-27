package com.core.thread;

/**
 * Created by lihuiyan on 2016/10/26.
 * ThreadLocal用来实现线程隔离
 */
public class ThreadLocalExample {
    private static final ThreadLocal<Long> longLocal = new ThreadLocal<Long>() {
        public Long initialValue() {
            return new Long(100L);
        }
    };

    private static final ThreadLocal<String> stringLocal = new ThreadLocal<String>() {
        public String initialValue() {
            return new String("abc");
        }
    };

    private static void set() {
        longLocal.set(Thread.currentThread().getId());
        stringLocal.set(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        /**
         * 主线程 set()
         */
        set();
        System.out.println(longLocal.get());
        System.out.println(stringLocal.get());
        Thread t1 = new Thread() {
            @Override
            public void run() {
                /**
                 * t1线程set()
                 */
                set();
                System.out.println(longLocal.get());
                System.out.println(stringLocal.get());
            }
        };
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(longLocal.get());
        System.out.println(stringLocal.get());
    }
}
