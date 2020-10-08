package org.Unit03.Demo12;

/**
 * 使用匿名内部类创建线程。
 * @Author: Z.HAN
 * @Date: 2020/9/27 16:30
 */
public class NoNameThreadDemo {
    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println(Thread.currentThread().getName() + "---" + i);
                }
            }
        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println(Thread.currentThread().getName() + "---" + i);
                }
            }
        }){}.start();
    }
}
