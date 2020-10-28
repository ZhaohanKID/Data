package org.Unit05.Thread;

/**
 * @Author: Z.HAN
 * @Date: 2020/10/17 21:52
 */
public class ThreadDemo {
    public static void main(String[] args) {
        Person person = new Person();

        Thread1 thread1 = new Thread1(person);
        Thread2 thread2 = new Thread2(person);

        Thread t1 = new Thread(thread1);
        Thread t2 = new Thread(thread2);

        t1.start();
        t2.start();
    }
}
