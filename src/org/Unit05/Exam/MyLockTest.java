package org.Unit05.Exam;

import java.util.concurrent.TimeUnit;

public class MyLockTest {
    public static void main(String[] args) {
        MyLock myLock = new MyLock();
        new Thread(() -> {
            myLock.lock();
            System.out.println(Thread.currentThread().getName() + " lock");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " unlock");
            myLock.unlock();
        }).start();
        new Thread(() -> {
            myLock.lock();
            System.out.println(Thread.currentThread().getName() + " lock");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " unlock");
            myLock.unlock();
        }).start();
    }
}
