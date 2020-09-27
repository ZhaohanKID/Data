package org.Unit03.Test04;

public class MyThread extends Thread {
    private static int ticket = 100;

    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (true) {
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + "正在售卖第" + (ticket--) + "张票。");
            }
        }
    }
}
