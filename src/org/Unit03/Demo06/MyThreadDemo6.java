package org.Unit03.Demo06;

/**
 *  当进程中剩余的线程都是守护线程时，JVM 结束执行。
 */

public class MyThreadDemo6 {
    public static void main(String[] args) {
        MyThread6 myThread1 = new MyThread6();
        MyThread6 myThread2 = new MyThread6();

        myThread1.setName("Jay");
        myThread2.setName("William");

        // 守护线程设置为true。主基地结束，其余两个线程一会也会结束。
        myThread1.setDaemon(true);
        myThread2.setDaemon(true);

        myThread1.start();
        myThread2.start();

        // 获取主线程。
        Thread.currentThread().setName("主基地：");
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() + i);
        }
        /*
            "C:\Program Files\Java\jdk-12.0.2\bin\java.exe" "-javaagent:D:\Idea.2019\IntelliJ IDEA 2019.3.3\lib\idea_rt.jar=64001:D:\Idea.2019\IntelliJ IDEA 2019.3.3\bin" -Dfile.encoding=UTF-8 -classpath "D:\IntelliJ IDEA程序\程序\out\production\程序" org.Unit03.Demo06.MyThreadDemo6
William: 0
William: 1
William: 2
William: 3
William: 4
William: 5
Jay: 0
主基地：0
Jay: 1
William: 6
William: 7
William: 8
William: 9
William: 10
William: 11
William: 12
Jay: 2
主基地：1
Jay: 3
William: 13
Jay: 4
主基地：2
Jay: 5
Jay: 6
Jay: 7
Jay: 8
Jay: 9
Jay: 10
Jay: 11
Jay: 12
Jay: 13
Jay: 14
Jay: 15
Jay: 16
Jay: 17
Jay: 18
Jay: 19
Jay: 20
William: 14

Process finished with exit code 0

         */
    }
}
