package org.Unit03.Demo10;

public class GetStudent implements Runnable {
    private Student s;

    public GetStudent(Student s) {
        this.s = s;
    }

    @Override
    public void run() {
        //Student s = new Student();
        while (true) {
            synchronized (s) {
                // 没有数据就等待
                if (!s.flag) {
                    try {
                        s.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                // 消费数据
                System.out.println(s.name + "---" + s.age);
                // 数据消费完之后，标记没有数据了。
                s.flag = false;
                // 唤醒等待的线程。
                s.notify();
            }
        }
    }
}
