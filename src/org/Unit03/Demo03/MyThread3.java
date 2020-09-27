package org.Unit03.Demo03;

public class MyThread3 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("有异常！");
            }
            System.out.println(getName() + "-" + i);
        }
    }
}
