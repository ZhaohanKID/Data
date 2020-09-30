package org.Unit03.Demo11;

/**
 *  运行结果：
 *      null---0
 *
 *      出现问题：发现我们运行输出的结果是null---0，是因为
 *      在每个线程中都创建了一个学生对象，这两个对象并不是同一个对象。
 *      而我们要求的学生对象应该是同一个，同一个数据源。
 *
 *      set和get创建的学生是
 *
 *      通过同步方法实现等待唤醒机制。
 */

public class StudentDemo {
    public static void main(String[] args) {
        Student student = new Student();

        GetStudent gs = new GetStudent(student);
        SetStudent ss = new SetStudent(student);

        Thread t1 = new Thread(gs);
        Thread t2 = new Thread(ss);

        t1.start();
        t2.start();
    }
}
