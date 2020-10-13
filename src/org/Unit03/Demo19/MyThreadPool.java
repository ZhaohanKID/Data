package org.Unit03.Demo19;

/**
 * @Author: Z.HAN
 * @Date: 2020/10/11 15:18
 */
public class MyThreadPool implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 30; i++) {
            System.out.println(Thread.currentThread().getName() + "--" + i);
        }
    }
}
