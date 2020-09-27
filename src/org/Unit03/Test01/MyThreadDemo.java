package org.Unit03.Test01;

/**
 *  方法一： 使用继承Thread类的方法。
 *
 *  方法二： 使用实现Runnable接口的方法。
 *
 *      根据现实情况，每次售票时，会出现重复售票的情况，而且会出现负数票。
 */

public class MyThreadDemo {
    public static void main(String[] args) {
        /*MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();
        MyThread myThread3 = new MyThread();

        myThread1.setName("窗口一：");
        myThread2.setName("窗口二：");
        myThread3.setName("窗口三：");

        myThread1.start();
        myThread2.start();
        myThread3.start();*/

        // 方法二：
        MyThread2 myThread = new MyThread2();

        Thread t1 = new Thread(myThread, "窗口一：");
        Thread t2 = new Thread(myThread, "窗口二：");
        Thread t3 = new Thread(myThread, "窗口三：");

        t1.start();
        t2.start();
        t3.start();
    }
}
