package org.Unit05.Thread;

/**
 * @Author: Z.HAN
 * @Date: 2020/10/17 21:51
 */
public class Thread1 implements Runnable {
    private Person person;

    public Thread1(Person person) {
        this.person = person;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (person) {
                if (person.flag) {
                    try {
                        person.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                person.name = "Andy";
                person.flag = true;
                person.notify();
            }
        }
    }
}
