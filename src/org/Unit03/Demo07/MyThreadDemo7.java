package org.Unit03.Demo07;

public class MyThreadDemo7 {
    public static void main(String[] args) {
        MyThread7 myThread1 = new MyThread7();

        //启动线程
        myThread1.start();

        // 休眠时间超过三秒，就终止你。
        try {
            // 主线程休眠三秒。
            Thread.sleep(3000);
            // myThread1.stop();
            myThread1.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
