package org.Unit03.Test03;

public class MyRunnableDemo {
    public static void main(String[] args) {
        MyRunnable mr = new MyRunnable();

        new Thread(mr, "兔子").start();
        new Thread(mr, "乌龟").start();
    }
}
