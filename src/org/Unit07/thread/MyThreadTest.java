package org.Unit07.thread;

/**
 * @Author: Z.HAN
 * @Date: 2020/11/14 12:59
 */
public class MyThreadTest {
    public static void main(String[] args) {
        Object o = new Object();

        MyThreadA threadA = new MyThreadA(o);
        MyThreadB threadB = new MyThreadB(o);
        MyThreadC threadC = new MyThreadC(o);

        threadA.start();
        threadB.start();
        threadC.start();
    }
}
