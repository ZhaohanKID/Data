package org.Unit03.Demo09;

public class deadLock extends Thread {
    private boolean flag;
    private static Object lockA = new Object();
    private static Object lockB = new Object();

    // 构造方法
    public deadLock(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        if (flag) {
            synchronized (lockA) {
                System.out.println("if lockA");
                synchronized (lockB) {
                    System.out.println("if lockB");
                }
            }
        } else {
            synchronized (lockB) {
                System.out.println("else lockB");
                synchronized (lockA) {
                    System.out.println("else lockA");
                }
            }
        }
    }
}
