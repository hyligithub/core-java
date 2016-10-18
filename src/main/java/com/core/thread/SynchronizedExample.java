package com.core.thread;


/**
 * Created by lihuiyan on 2016/10/18.
 */
public class SynchronizedExample {
    public static void main(String[] args) {
        /**
         * 当一个线程访问对象的sync块或者方法时,其他线程访问同一个对象的同一个sync方法或者块时就会被阻塞
         */
        Runnable runnableTest = new RunnableTest();
        //t1,t2实际是调用同一个runnable对象的sync块,所以一个线程跑完，另一个线程才能继续跑
        Thread t1 = new Thread(runnableTest, "t1");
        Thread t2 = new Thread(runnableTest, "t2");
//        t1.start();
//        t2.start();
        //t3,t4调用的是不同Runnable对象的sync块，所以线程不会阻塞
        Thread t3 = new Thread(new RunnableTest(), "t3");
        Thread t4 = new Thread(new RunnableTest(), "t4");
//        t3.start();
//        t4.start();

        /**
         * 当一个线程访问对象的sync块或者方法时，其他线程可以访问该对象的非sync块和方法
         */
        SynchronizedTest st = new SynchronizedTest();
        Thread t5 = new Thread(new Runnable() {
            @Override
            public void run() {
                st.syncMethod();
            }
        }, "t5");
        Thread t6 = new Thread(new Runnable() {
            @Override
            public void run() {
                st.nonSyncMethod();
            }
        }, "t6");
//        t5.start();
//        t6.start();

        /**
         * 当一个线程访问对象的sync块或者方法时，其他线程访问该对象的其他sync块或者方法会阻塞
         */
        Thread t7 = new Thread(new Runnable() {
            @Override
            public void run() {
                st.syncMethod();
            }
        }, "t7");
        Thread t8 = new Thread(new Runnable() {
            @Override
            public void run() {
                st.syncMethod1();
            }
        }, "t8");
        t7.start();
        t8.start();


    }
}

class SynchronizedTest {
    public void syncMethod() {
        synchronized (this) {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName() + "sync loop:" + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void syncMethod1() {
        synchronized (this) {
            for (int i = 0; i < 4; i++) {
                try {
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName() + "sync1 loop:" + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void nonSyncMethod() {
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName() + "non-sync loop:" + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class RunnableTest implements Runnable {
    @Override
    public void run() {
        synchronized (this) {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName() + ":" + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}