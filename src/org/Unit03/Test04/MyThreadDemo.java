package org.Unit03.Test04;

public class MyThreadDemo {
    public static void main(String[] args) {
        MyThread myThread = new MyThread("窗口一：");
        MyThread myThread1 = new MyThread("窗口二：");
        MyThread myThread2 = new MyThread("窗口三：");

        myThread.start();
        myThread1.start();
        myThread2.start();
    }
}
