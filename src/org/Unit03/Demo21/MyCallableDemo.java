package org.Unit03.Demo21;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Author: Z.HAN
 * @Date: 2020/10/11 16:10
 */
public class MyCallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(2);
        MyCallable mc = new MyCallable(100);
        MyCallable mc2 = new MyCallable(200);

        Future<Integer> future = es.submit(mc);
        Future<Integer> future2 = es.submit(mc2);

        int num = future.get();
        int num2 = future2.get();

        System.out.println(num);
        System.out.println(num2);

        es.shutdown();
    }
}
