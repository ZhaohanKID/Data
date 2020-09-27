package org.Unit03.Test01;


public class MyThread2 implements Runnable {
    static int tickets = 50;
    static Object object = new Object();
    @Override
    public void run() {

        while (true) {
            synchronized (object) {
                if (tickets > 0) {
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "卖出去标号为 " + (tickets--) + "的这张票");
                }
            }
        }

        /*
            举例：
                下课上厕所。
                有60个学生，大家共用这一个厕所。
                A同学进坑，然后关门了。B同学来了，发现厕所门关了。B就不能去上了。
                A同学上完后，开门出来，这时候，B,C,D...同学都可以抢坑位。
                A可能刚打开门，又自己进去了，关上了门。（可能A同学拉肚子。）
         */
    }
}
