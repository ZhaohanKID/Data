package org.Unit03.Test06;

/**
 * @Author: Z.HAN
 * @Date: 2020/10/10 14:27
 */
public class SaleTicket implements Runnable {
    private static int ticket = 50;
    @Override
    public void run() {
        ticket();
    }

    private synchronized static void ticket() {
        while (true) {
            if (ticket > 0) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "正在售卖第" + (ticket--) + "张票");
            }
        }
    }
}
