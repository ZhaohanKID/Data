package org.Unit03.Demo15;

/**
 * @Author: Z.HAN
 * @Date: 2020/10/11 9:46
 */
public class DeadLock extends Thread {
    private boolean flag;

    public DeadLock(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        if (flag) {
            synchronized(MyLock.objectA) {
                System.out.println("objectA");
                synchronized (MyLock.objectB) {
                    System.out.println("objectB");
                }
            }
        } else {
            synchronized (MyLock.objectB) {
                System.out.println("objectB");
                synchronized (MyLock.objectA) {
                    System.out.println("objectA");
                }
            }
        }
    }
}
