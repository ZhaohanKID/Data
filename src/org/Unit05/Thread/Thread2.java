package org.Unit05.Thread;

/**
 * @Author: Z.HAN
 * @Date: 2020/10/17 21:52
 */
public class Thread2 implements Runnable {
    private Person person;

    public Thread2(Person person) {
        this.person = person;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (person) {
                if (!person.flag) {
                    try {
                        person.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(person.name);
                person.flag = false;
                person.notify();
            }
        }
    }
}
