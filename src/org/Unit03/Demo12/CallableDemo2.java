package org.Unit03.Demo12;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Author: Z.HAN
 * @Date: 2020/9/27 16:07
 */
public class CallableDemo2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(2);
        Future<Integer> f1 = pool.submit(new MyCallable2(5));
        Future<Integer> f2 = pool.submit(new MyCallable2(100));

        Integer number1 = f1.get();
        Integer number2 = f2.get();

        System.out.println(number1);
        System.out.println(number2);

        pool.shutdown();
    }
}
