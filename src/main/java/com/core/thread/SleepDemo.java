package com.core.thread;

/**
 * Created by lihuiyan on 2016/10/20.
 * 线程持有sleep方法，调用该方法会使线程从运行状态转化为休眠（阻塞）状态，但是不会释放对象锁
 */
public class SleepDemo {

    public static void main(String[] args) {
        MyRunnable1 r = new MyRunnable1();
        Thread t1 = new Thread(r, "t1");
        Thread t2 = new Thread(r, "t2");
        t1.start();
        t2.start();
    }
}

class MyRunnable1 implements Runnable {

    @Override
    public void run() {
        synchronized (this) {
            try {
                for (int i = 0; i < 5; i++) {
                    System.out.println(Thread.currentThread().getName() + "--" + i);
                    /**
                     * t1,t2引用同一个对象锁，
                     * 线程在模2为0的时候会休眠10ms，但是没有释放对象锁，所以其他线程还需继续等待，并不会获得cpu的执行权
                     */
                    if (i % 2 == 0) {
                        Thread.sleep(10);
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
