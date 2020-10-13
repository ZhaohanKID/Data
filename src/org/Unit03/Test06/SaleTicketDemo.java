package org.Unit03.Test06;

/**
 * @Author: Z.HAN
 * @Date: 2020/10/10 14:27
 */
public class SaleTicketDemo {
    public static void main(String[] args) {
        SaleTicket st = new SaleTicket();

        Thread t1 = new Thread(st, "窗口一：");
        Thread t2 = new Thread(st, "窗口一：");
        Thread t3 = new Thread(st, "窗口一：");

        t1.start();
        t2.start();
        t3.start();
    }
}
