package org.Unit03.Test06;

/**
 * @Author: Z.HAN
 * @Date: 2020/10/10 14:40
 */
public class SaleTicket2 extends Thread {
    private static int ticket = 50;
    private static Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (obj) {
                if (ticket > 0) {
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "卖出去标号为 " + (ticket--) + "的这张票");
                }
            }
        }
    }

}
