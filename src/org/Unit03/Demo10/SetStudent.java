package org.Unit03.Demo10;

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
            synchronized (s) {
                if (s.flag) { // 如果有数据，生产者等待。
                    try {
                        s.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                // 没有数据，生产数据，唤醒生产者。
                if (x % 2 == 0) {
                    s.name = "William";
                    s.age = 34;
                } else {
                    s.name = "Andy";
                    s.age = 50;
                }
                x++;
                s.flag = false;
                s.notify();

            }

        }

    }

}
