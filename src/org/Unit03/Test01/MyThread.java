package org.Unit03.Test01;

public class MyThread extends Thread {
    static int tickets = 150;
    @Override
    public void run() {
        while (true) {
            if (tickets > 0) {
                System.out.println(getName() + "卖出去标号为 " + (tickets--) + "的这张票");
            }
        }
    }
}
