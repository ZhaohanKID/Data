package org.Unit03.Demo01;

public class MyThread extends Thread {
    public MyThread() {
    }
    public MyThread(String name) {
        super(name);
    }
    @Override
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.println(getName() + i);
        }
    }
}
