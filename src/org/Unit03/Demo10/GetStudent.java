package org.Unit03.Demo10;

public class GetStudent implements Runnable {
    private Student student;

    public GetStudent(Student student) {
        this.student = student;
    }

    @Override
    public void run() {
        //Student s = new Student();
            while (true) {
                synchronized (student) {
                    // 没有数据就等待
                    if (!student.flag) {
                        try {
                            student.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    // 消费数据
                    System.out.println(student.name + "---" + student.age);
                    // 数据消费完之后，标记没有数据了。
                    student.flag = false;
                    // 唤醒等待的线程。
                    student.notify();
            }

        }


    }
}
