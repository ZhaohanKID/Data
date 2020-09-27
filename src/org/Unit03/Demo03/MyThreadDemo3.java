package org.Unit03.Demo03;

public class MyThreadDemo3 {
    public static void main(String[] args) {
        MyThread3 myThread1 = new MyThread3();
        MyThread3 myThread2 = new MyThread3();
        MyThread3 myThread3 = new MyThread3();

        myThread1.setName("终南山");
        myThread2.setName("袁隆平");
        myThread3.setName("华罗庚");

        myThread1.start();
        myThread2.start();
        myThread3.start();
    }
}
