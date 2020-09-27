package org.Unit03.Test02;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SaleTicket implements Runnable {
    private int tickets = 50;
    private Lock lock = new ReentrantLock();

    @Override
    public void run() {

        while (true) {



            // 创建锁对象。
            // 上锁。
            lock.lock();
            if (tickets > 0) {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "卖出去标号为 " + (tickets--) + "的这张票");


            }
            // 解锁
            lock.unlock();
        }
    }



}
