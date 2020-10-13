package org.Unit03.Demo22;

/**
 * @Author: Z.HAN
 * @Date: 2020/10/11 16:44
 */
public class MyThread {
    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 30; i++) {
                    System.out.println(Thread.currentThread().getName() + i);
                }
            }
        };

        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < 30; i++) {
                            System.out.println(Thread.currentThread().getName() + i);
                        }
                    }
                }
        ){};

        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < 30; i++) {
                            System.out.println("hello" + i);
                        }
                    }
                }
            ){
            @Override
            public void run() {
                for (int i = 0; i < 30; i++) {
                    System.out.println("world" + i);
                }
            }
        };
    }
}
