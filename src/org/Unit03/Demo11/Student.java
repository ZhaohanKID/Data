package org.Unit03.Demo11;

public class Student {
    private String name;
    private int age;
    private boolean flag; // 标记是否有数据。

    public synchronized void set(String name, int age) {
        while (true) {
            // 判断是否有数据，如果有数据，等待
            if (this.flag) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.name = name;
            this.age = age;

            this.flag = true;
            this.notify();
        }
    }

    public synchronized void get() {
        if (!this.flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(this.name + "---" + this.age);
        this.flag = false;
        this.notify();
    }
}
