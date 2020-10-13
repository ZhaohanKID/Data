package org.Unit03.Demo16;

/**
 * @Author: Z.HAN
 * @Date: 2020/10/11 10:29
 */
public class StudentDemo {
    public static void main(String[] args) {
        // 创建学生对象
        Student student = new Student();
        // 创建自定义线程类对象
        SetThread setThread = new SetThread(student);
        GetThread getThread = new GetThread(student);
        // 创建Thread类对象，将自定义线程类对象作为参数传递
        Thread thread = new Thread(setThread,"线程一");
        Thread thread2 = new Thread(getThread,"线程二");
        // 启动线程
        thread.start();
        thread2.start();
    }
}
