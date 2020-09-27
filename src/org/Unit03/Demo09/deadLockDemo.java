package org.Unit03.Demo09;

/**
 *      如何写一个死锁的代码？？
 *          以后面试的时候可能让你写一个死锁的代码。
 */

public class deadLockDemo {
    public static void main(String[] args) {
        deadLock deadLock1 = new deadLock(true);
        deadLock deadLock2 = new deadLock(false);

        deadLock1.start();
        deadLock2.start();
    }
}
