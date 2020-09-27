package org.Unit03.Demo02;

public class MyThread2 extends Thread {
    public MyThread2() {
    }
    public MyThread2(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.println(getName() + i);
        }
    }
}
