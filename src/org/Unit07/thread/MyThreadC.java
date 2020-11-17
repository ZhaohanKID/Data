package org.Unit07.thread;

/**
 * @Author: Z.HAN
 * @Date: 2020/11/14 12:57
 */
public class MyThreadC extends Thread {
    public static Object o;
    public MyThreadC(Object o) {
        this.o = o;
    }
    @Override
    public void run() {
        synchronized (o) {
            try {
                Thread.sleep(5000);
                o.notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
