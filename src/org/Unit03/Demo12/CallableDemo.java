package org.Unit03.Demo12;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: Z.HAN
 * @Date: 2020/9/27 16:01
 */
public class CallableDemo {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(2);
        pool.submit(new MyCallable());
        pool.submit(new MyCallable());

        pool.shutdown();
    }
}
