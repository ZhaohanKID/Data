package org.Unit03.Demo07;

import java.util.Date;

public class MyThread7 extends Thread {
    @Override
    public void run() {
        System.out.println("线程开始执行" + new Date());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("程序出现错误！");
        }
        System.out.println("线程结束执行" + new Date());
    }
}
