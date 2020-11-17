package org.Unit07.thread;

/**
 * @Author: Z.HAN
 * @Date: 2020/11/14 12:56
 */
public class MyThreadB extends Thread {
    public static Object o;
    public MyThreadB(Object o) {
        this.o = o;
    }
    @Override
    public void run() {
        synchronized (o) {
            System.out.println(Thread.currentThread().getName() + "。。。start");
            try {
                o.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "。。。end");
        }
    }
}
