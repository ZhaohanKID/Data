package org.Unit03.Demo02;



public class ThreadPriorityDemo {
    public static void main(String[] args) {
        MyThread2 myThread1 = new MyThread2();
        MyThread2 myThread2 = new MyThread2();
        MyThread2 myThread3 = new MyThread2();

        // 设置线程名臣。
        myThread1.setName("1:");
        myThread2.setName("2:");
        myThread3.setName("3:");

        // 设置线程优先级。
        myThread1.setPriority(10);
        myThread3.setPriority(1);

        // 获取线程优先级。
        System.out.println(myThread1.getPriority());
        System.out.println(myThread2.getPriority());
        System.out.println(myThread3.getPriority());

        myThread1.start();
        myThread2.start();
        myThread3.start();
    }
}
