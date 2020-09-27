package org.Unit03.Demo08;

/**
 *  第二种方法：
 *      1.创建自定义线程类。
 *      2.重写 run 方法
 *      3.创建自定义线程类对象
 *      4.创建多个Thread类对象，将自定义线程类对象作为参数传递。
 *      5.启动线程。
 *
 *    为什么要有创建线程的第二种方法？
 *      1.截屏见。
 */

public class MyRunnableDemo {
    public static void main(String[] args) {
        MyRunnable mr = new MyRunnable();

        Thread t1 = new Thread(mr, "Andy");
        Thread t2 = new Thread(mr, "Jay");

        t1.start();
        t2.start();
    }
}
