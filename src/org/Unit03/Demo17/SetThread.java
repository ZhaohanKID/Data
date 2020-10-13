package org.Unit03.Demo17;

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
            if (x % 2 == 0) {
                student.set("William", 30);
            } else {
                student.set("Andy", 5);
            }
            x++;
        }
    }
}
