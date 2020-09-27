package org.Unit03.Demo05;

/**
 *  public static void yield() :
 *          线程礼让。 减小抢占竞争。
 *
 *        静态方法要在线程类使用，非静态在调用时使用。
 */

public class MyThread5 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            System.out.println(getName() + ": " + i);
            Thread.yield();
        }
    }
}
