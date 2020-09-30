package org.Unit03.Demo11;

public class SetStudent implements Runnable {
    private Student s;

    public SetStudent(Student s) {
        this.s = s;
    }

    int x = 0;

    @Override
    public void run() {
        //Student s = new Student();
        while (true) {
            // 没有数据，生产数据，唤醒生产者。
            if (x % 2 == 0) {
                s.set("Allen", 30);
            } else {
                s.set("William", 34);
            }
            x++;
        }
    }
}
