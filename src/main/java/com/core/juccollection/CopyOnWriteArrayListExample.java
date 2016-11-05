package com.core.juccollection;

import com.core.PrintUtil;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by lihuiyan on 2016/11/5.
 * copyonwriteArrayList 是线程安全的动态数组，是通过独占锁和volatile实现互斥以及内存可见
 * 在对cosarraylist进行迭代时不会出现fail-fast机制，进行迭代的时候是通过复制一个新的数据来实现的
 * coslist的遍历性能很好，但是更新数据内容（add,remove）性能很差，因为需要复制一个数据，操作完毕之后
 * 需要再将数组赋给原volatile数据。
 */
public class CopyOnWriteArrayListExample {
    private static List<String> list = new CopyOnWriteArrayList<>();

    public static void main(String[] args) {
        Thread ta = new MyThread("ta");
        Thread tb = new MyThread("tb");
        ta.start();
        tb.start();

    }

    private static void printAll() {
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            PrintUtil.print(iterator.next());
        }
    }

    static class MyThread extends Thread {
        public MyThread(String name) {
            super(name);
        }
        public void run() {
            for (int i = 0; i < 3; i++) {
                list.add(Thread.currentThread().getName() + i);
                printAll();
            }
        }
    }
}
