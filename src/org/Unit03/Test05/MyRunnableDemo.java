package org.Unit03.Test05;

public class MyRunnableDemo {
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();

        Thread thread1 = new Thread(myRunnable, "窗口一：");
        Thread thread2 = new Thread(myRunnable, "窗口二：");
        Thread thread3 = new Thread(myRunnable, "窗口三：");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
