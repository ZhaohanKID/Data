package org.Unit03.Demo12;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: Z.HAN
 * @Date: 2020/9/27 15:47
 */
public class ExecutorServiceDemo {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(2);

        pool.submit(new  MyRunnable());
        pool.submit(new MyRunnable());
    }
}
