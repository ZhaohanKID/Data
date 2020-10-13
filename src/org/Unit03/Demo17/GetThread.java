package org.Unit03.Demo17;

/**
 * @Author: Z.HAN
 * @Date: 2020/10/11 10:21
 */
public class GetThread implements Runnable {
    private Student student;

    public GetThread(Student student) {
        this.student = student;
    }

    @Override
    public void run() {
        while (true) {
            student.get();
        }
    }
}
