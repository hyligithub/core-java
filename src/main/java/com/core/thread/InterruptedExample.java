package com.core.thread;

/**
 * Created by lihuiyan on 2016/10/24.
 * interrupt 意为中断线程，线程可以自己中断自己，也可以其他线程调用线程的interrupt()方法来中断线程
 * 处于运行状态的线程,isInterrupted() 方法返回true,该方法判断线程的中断标记是否为true
 * 处于阻塞状态的线程,inInterrupted()方法返回true,但是由于线程处于阻塞状态，虚拟机会立刻清除中断标记，同时产生一个InterruptedException异常
 *
 * 综上:处理线程(运行状态，阻塞状态)终止的通用写法如下：
 *    @Override
 *    public void run(){
 *        try{
 *             //1.如果线程处于运行状态，中断标记为true，此处就会跳出循环，如果线程处于阻塞状态，会抛出InterruptedException
 *             while(!isInterrupted()){
 *               //执行任务  .....
 *             }
 *        }catch(InterruptedException){
 *           // 2. InterruptedException异常保证，当InterruptedException异常产生时，线程被终止。
 *        }
 *    }
 */
public class InterruptedExample {
    public static void main(String[] args) {
        Thread t1 = new MyThread("t1");
        System.out.println(t1.getName() + t1.getState() + " is NEW");
        t1.start();
        System.out.println(t1.getName() + t1.getState() + " is RUNNABLE");
        try {
            //主线程休眠300ms
            Thread.sleep(300);
            //主线程调用t1线程的中断方法，使其中断,因为t1线程处于阻塞状态，会清除中断标记，同时抛出interruptedException异常
            t1.interrupt();
            System.out.println(t1.getName() + t1.getState() + " is interrupted");

            Thread.sleep(300);
            System.out.println(t1.getName() + t1.getState() + " is interrupted now");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class MyThread extends Thread {
        public MyThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            int i = 0;
            try {
                while (!isInterrupted()) {
                    Thread.sleep(100);
                    i++;
                    System.out.println(Thread.currentThread().getName() + "***" + i);
                }
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + Thread.currentThread().getState() + " catch InterruptedException");
            }
        }
    }
}
