package org.Unit03.Demo18;

/**
 * @Author: Z.HAN
 * @Date: 2020/10/11 14:27
 */
public class ThreadGroupDemo {
    public static void main(String[] args) {
        // 获取默认分组
        method1();
        System.out.println("---------------------");
        method2();
    }
    public static void method2() {
        ThreadGroup threadGroup = new ThreadGroup("守护线程");

        MyThreadGroup tg = new MyThreadGroup();

        Thread thread1 = new Thread(threadGroup, tg);
        Thread thread2 = new Thread(threadGroup, tg);

        System.out.println(thread1.getThreadGroup().getName());
        System.out.println(thread2.getThreadGroup().getName());
        System.out.println(Thread.currentThread().getThreadGroup().getName());

        // 将这个组设置成守护线程
        threadGroup.setDaemon(true);
    }
    public static void method1() {
        MyThreadGroup tg = new MyThreadGroup();

        Thread thread1 = new Thread(tg);
        Thread thread2 = new Thread(tg);

        ThreadGroup threadGroup1 = thread1.getThreadGroup();
        String name1 = threadGroup1.getName();
        System.out.println(name1+"---");

        System.out.println(thread1.getThreadGroup().getName());
        System.out.println(thread2.getThreadGroup().getName());
        System.out.println(Thread.currentThread().getThreadGroup().getName());
    }
}
