package org.Unit03.Demo12;

/**
 * @ Author: Z.HAN
 * @ Date: 2020/9/27 15:00
 */
public class ThreadGroupDemo {
    public static void main(String[] args) {
        //method1();
        method2();
    }

    private static void method2() {
        ThreadGroup tg = new ThreadGroup("KID");

        MyRunnable mr = new MyRunnable();

        Thread t1 = new Thread(tg, mr, "怪盗基德");
        Thread t2 = new Thread(tg, mr, "黑羽快斗");

        System.out.println(t1.getThreadGroup().getName());
        System.out.println(t2.getThreadGroup().getName());
    }

    public static void method1() {
        MyRunnable mr = new MyRunnable();

        Thread t1 = new Thread(mr, "Allen");
        Thread t2 = new Thread(mr, "Andy");

        ThreadGroup tg1 = t1.getThreadGroup();
        ThreadGroup tg2 = t2.getThreadGroup();

        String s1 = tg1.getName();
        String s2 = tg2.getName();

        System.out.println(s1);
        System.out.println(s2);

        // 链式编程，获取主线程的线程组名称。
        System.out.println(Thread.currentThread().getThreadGroup().getName());

    }
}
