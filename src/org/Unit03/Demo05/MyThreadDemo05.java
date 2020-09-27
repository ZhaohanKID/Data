package org.Unit03.Demo05;


public class MyThreadDemo05 {
    public static void main(String[] args) {
        // 创建线程类对象
        MyThread5 myThread1 = new MyThread5();
        MyThread5 myThread2 = new MyThread5();

        // 设置名称。
        myThread1.setName("Andy");
        myThread2.setName("Jay");

        myThread1.start();
        myThread2.start();
    }
}
