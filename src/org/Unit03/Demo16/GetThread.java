package org.Unit03.Demo16;

import org.Unit03.Demo10.GetStudent;

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
            synchronized (student) {
                // 如果没有数据就等待
                if (!student.flag) {
                    try {
                        student.wait(); // 线程等待的同时会释放锁
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(student.getName() + "---" + student.getAge());

                student.flag = false;
                student.notify();
            }
        }
    }
}
