package org.Unit03.Demo15;

/**
 * @Author: Z.HAN
 * @Date: 2020/10/11 9:47
 */
public class DeadLockDemo {
    public static void main(String[] args) {
        DeadLock deadLock1 = new DeadLock(true);
        DeadLock deadLock2 = new DeadLock(false);

        deadLock1.start();
        deadLock2.start();

        /*
            objectA
            objectB
            或者
            objectB
            objectA
         */
    }
}
