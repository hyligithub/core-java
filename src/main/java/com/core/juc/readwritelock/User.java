package com.core.juc.readwritelock;

import com.core.PrintUtil;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by lihuiyan on 2016/11/3.
 */
public class User {
    private String name;
    private MyCount myCount;
    private ReadWriteLock readWriteLock;

    public void getCash() {
        new Thread() {
            @Override
            public void run() {
                readWriteLock.readLock().lock();
                try {
                    PrintUtil.print(Thread.currentThread().getName() + " getCash");
                    myCount.getCash();
                    Thread.sleep(1);
                    PrintUtil.print(Thread.currentThread().getName() + " getCash End");
                } catch (InterruptedException i) {
                    i.printStackTrace();
                } finally {
                    readWriteLock.readLock().unlock();
                }
            }
        }.start();
    }

    public void setCash(final double cash) {
        new Thread() {
            @Override
            public void run() {
                readWriteLock.writeLock().lock();
                try {
                    PrintUtil.print(Thread.currentThread().getName() + " setCash start");
                    myCount.setCash(cash);
                    Thread.sleep(1);
                    PrintUtil.print(Thread.currentThread().getName() + " setCash End");
                } catch (InterruptedException i) {
                    i.printStackTrace();
                } finally {
                    readWriteLock.writeLock().unlock();
                }
            }
        }.start();
    }

    public User(String name, MyCount myCount) {
        this.readWriteLock = new ReentrantReadWriteLock();
        this.name = name;
        this.myCount = myCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MyCount getMyCount() {
        return myCount;
    }

    public void setMyCount(MyCount myCount) {
        this.myCount = myCount;
    }
}
