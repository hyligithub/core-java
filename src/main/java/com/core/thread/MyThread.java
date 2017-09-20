package com.core.thread;

/**
 * Created by lihuiyan on 2016/10/17.
 */
public class MyThread extends Thread {

    public static void main(String[] args) {
//        System.out.println("主线程名字：" + Thread.currentThread().getName());
//        System.out.println(Thread.currentThread().getThreadGroup().getName());

        Thread thread = new MyThread("myThread");
        thread.run();//直接调用run方法,线程名还是main
        thread.start();//新启动一个线程
    }

    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("线程名字：" + Thread.currentThread().getName());
//        System.out.println(Thread.currentThread().getThreadGroup().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
