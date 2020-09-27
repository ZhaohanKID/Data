package org.Unit03.Demo01;

public class MyThreadDemo {
    public static void main(String[] args) {
/*        //创建MyThread对象。
        MyThread myThread = new MyThread();
        //启动线程
         // 想要实现多线程，一定要用JVM启动线程。
        // 而如果直接调用run方法，那就是普通的调用，不能起到多线程的效果。
        myThread.setName("线程一");
        myThread.start();

        // 应该创建两个对象，都调用start方法
        MyThread myThread1 = new MyThread();
        myThread1.setName("线程二");
        myThread1.start();*/


        // 使用有参构造：
        MyThread myThread = new MyThread("线程一：");
        myThread.start();

        MyThread myThread1 = new MyThread("线程二：");
        myThread1.start();



        // 获取主线程 (主方法线程对象。)
        System.out.println(Thread.currentThread().getName());
    }
}
