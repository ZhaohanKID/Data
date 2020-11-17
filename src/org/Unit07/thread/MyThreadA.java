package org.Unit07.thread;

/**
 * @Author: Z.HAN
 * @Date: 2020/11/13 9:35
 */
public class MyThreadA extends Thread {
    public static Object o;
    public MyThreadA(Object o) {
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
