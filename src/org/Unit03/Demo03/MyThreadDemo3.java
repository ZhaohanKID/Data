package org.Unit03.Demo03;

public class MyThreadDemo3 {
    public static void main(String[] args) {
        MyThread3 myThread1 = new MyThread3();
        MyThread3 myThread2 = new MyThread3();
        MyThread3 myThread3 = new MyThread3();

        myThread1.setName("喜羊羊");
        myThread2.setName("美羊羊");
        myThread3.setName("灰太狼");

        myThread1.start();
        myThread2.start();
        myThread3.start();
    }
}
