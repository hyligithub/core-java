package com.core.thread;

/**
 * Created by lihuiyan on 2016/10/19.
 * 验证类锁、实例锁的访问
 */
public class SynchronizedDemo {
    public static void main(String[] args) {
        lockTest1();
        lockTest2();
        lockTest3();
        lockTest4();
    }

    /**
     * 访问同一个实例的不同加锁方法，不能同时访问
     */
    private static void lockTest1() {
        SynchronizedMethodAndClass x = new SynchronizedMethodAndClass();
        SynchronizedMethodAndClass y = new SynchronizedMethodAndClass();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                x.syncMethodA();
            }
        }, "t1");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                x.syncMethodB();
            }
        }, "t2");
        t1.start();
        t2.start();
    }

    /**
     * 访问不同实例的加锁方法，可以同时访问
     */
    private static void lockTest2() {
        SynchronizedMethodAndClass x = new SynchronizedMethodAndClass();
        SynchronizedMethodAndClass y = new SynchronizedMethodAndClass();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                x.syncMethodA();
            }
        }, "t1");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                y.syncMethodA();
            }
        }, "t2");
        t1.start();
        t2.start();
    }

    /**
     * 访问不同实例的类锁，不能同时访问，相当于访问同一个类对象
     */
    private static void lockTest3() {
        SynchronizedMethodAndClass x = new SynchronizedMethodAndClass();
        SynchronizedMethodAndClass y = new SynchronizedMethodAndClass();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                x.syncClassA();
            }
        }, "t1");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                y.syncClassB();
            }
        }, "t2");
        t1.start();
        t2.start();
    }

    /**
     * 两个线程一个访问类锁，一个访问实例锁，可以同时访问，不冲突
     */
    private static void lockTest4() {
        SynchronizedMethodAndClass x = new SynchronizedMethodAndClass();
        SynchronizedMethodAndClass y = new SynchronizedMethodAndClass();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                x.syncMethodA();
            }
        }, "t1");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                y.syncClassA();
            }
        }, "t2");
        t1.start();
        t2.start();
    }
}

class SynchronizedMethodAndClass {
    public synchronized void syncMethodA() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(101);
                System.out.println(Thread.currentThread().getName() + "--syncA:" + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void syncMethodB() {
        for (int j = 0; j < 5; j++) {
            try {
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName() + "--syncB:" + j);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static synchronized void syncClassA() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName() + "--syncClassA:" + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static synchronized void syncClassB() {
        for (int j = 0; j < 5; j++) {
            try {
                Thread.sleep(101);
                System.out.println(Thread.currentThread().getName() + "--syncClassB:" + j);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
