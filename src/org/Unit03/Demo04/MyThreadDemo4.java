package org.Unit03.Demo04;

public class MyThreadDemo4 {
    public static void main(String[] args) {
        // 创建线程类对象
        MyThread4 myThread1 = new MyThread4();
        MyThread4 myThread2 = new MyThread4();
        MyThread4 myThread3 = new MyThread4();

        // 设置名称。
        myThread1.setName("Allen");
        myThread2.setName("Andy");
        myThread3.setName("Jay");

        myThread1.start();
        // 加入线程。
        try {
            myThread1.join();
        } catch (InterruptedException e) {
            System.out.println("出错了！");
        }
        myThread2.start();
        myThread3.start();
    }
}
