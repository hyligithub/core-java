package com.core.thread.interrupt;

/**
 * @Author Andy
 * @Date 2017/10/30 16:42.
 */
public class InterruptedDemo1 {

    BlockingMethodClass c1 = new BlockingMethodClass();

    public String add(String t) throws InterruptedException {
        return c1.add(t);
    }

    public void update(String t) throws InterruptedException {
        try {
            c1.update(t);
        } catch (InterruptedException e) {
            // do something1
            // do something2
            throw e;
        }
    }

    public static void main(String[] args) {
    }
}

class BlockingMethodClass {

    public String add(String t) throws InterruptedException {
        return t;
    }

    public void update(String t) throws InterruptedException {
        System.out.println("this is update");
    }

}
