package com.core.juc.readwritelock;

/**
 * Created by lihuiyan on 2016/11/3.
 */
public class ReadWriteLockExample {

    public static void main(String[] args) {
        MyCount myCount = new MyCount(6666666, 10000);
        User user = new User("andy", myCount);

        for (int i = 0; i < 3; i++) {
            user.getCash();
            user.setCash(100);
        }
    }
}
