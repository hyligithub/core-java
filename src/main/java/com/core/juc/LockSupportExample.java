package com.core.juc;

import com.core.PrintUtil;

import java.util.concurrent.locks.LockSupport;

/**
 * Created by lihuiyan on 2016/11/2.
 */
public class LockSupportExample {
    static Thread mainThread = null;

    public static void main(String[] args) {
        ThreadA ta = new ThreadA("ta");
        mainThread = Thread.currentThread();
        PrintUtil.print(mainThread.getName() + " call ta.start()");
        ta.start();
        PrintUtil.print(mainThread.getName() + " call LockSupport.part()");
        LockSupport.park(mainThread);
        PrintUtil.print(mainThread.getName() + " continue");
    }

    static class ThreadA extends Thread {
        public ThreadA(String name) {
            super(name);
        }
        @Override
        public void run() {
            PrintUtil.print(Thread.currentThread().getName() + " call LockSupport.unpark");
            LockSupport.unpark(mainThread);
        }
    }
}
