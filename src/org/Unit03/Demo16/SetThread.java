package org.Unit03.Demo16;

/**
 * @Author: Z.HAN
 * @Date: 2020/10/11 10:21
 */
public class SetThread implements Runnable {
    private Student student;
    private int x = 0;

    public SetThread(Student student) {
        this.student = student;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (student) {
                if (student.flag) {
                    // 等待
                    try {
                        student.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (x % 2 == 0) {
                    student.setName("William");
                    student.setAge(30);
                } else {
                    student.setName("Andy");
                    student.setAge(5);
                }
                x++;
                // 修改标记
                student.flag = true;
                student.notify();
            }
        }
    }
}
