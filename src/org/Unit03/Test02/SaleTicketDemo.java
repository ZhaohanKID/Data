package org.Unit03.Test02;

/**
 *    之前的方法我们不能看到在哪里加了锁，在哪里释放了锁。
 *
 *    Lock：这是一个接口，实现了比 synchronize 语句和方法更广泛的操作。
 */

public class SaleTicketDemo {
    public static void main(String[] args) {
        SaleTicket s = new SaleTicket();

        Thread thread1 = new Thread(s, "窗口一：");
        Thread thread2 = new Thread(s, "窗口二：");
        Thread thread3 = new Thread(s, "窗口三：");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
