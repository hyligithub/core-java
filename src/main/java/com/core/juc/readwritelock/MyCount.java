package com.core.juc.readwritelock;

import com.core.PrintUtil;

/**
 * Created by lihuiyan on 2016/11/3.
 */
public class MyCount {
    private long countId;
    private double cash;

    public MyCount(long countId, double cash) {
        this.countId = countId;
        this.cash = cash;
    }

    public long getCountId() {
        PrintUtil.print(Thread.currentThread().getName());
        return countId;
    }

    public void setCountId(long countId) {
        this.countId = countId;
    }

    public double getCash() {
        PrintUtil.print(Thread.currentThread().getName() + " cash =" + cash);
        return cash;
    }

    public void setCash(double cash) {
        PrintUtil.print(Thread.currentThread().getName() + " cash=" + cash);
        this.cash = cash;
    }

}
