package org.Unit03.Demo12;

/**
 * @ Author: Z.HAN
 * @ Date: 2020/9/27 15:01
 */
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + "---" + i);
        }
    }
}
