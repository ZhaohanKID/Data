package org.Unit03.Demo06;

public class MyThread6 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            System.out.println(getName() + ": " + i);
        }
    }
}
