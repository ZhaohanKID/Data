package org.Unit03.Demo20;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: Z.HAN
 * @Date: 2020/10/11 15:41
 */
public class MyCallableDemo {
    public static void main(String[] args) {
        // 1 创建线程池对象
        ExecutorService es = Executors.newFixedThreadPool(2);
        // 2 创建自定义类对象
        MyCallable mc = new MyCallable();
        // 3 提交 Callable 对象
        es.submit(mc);
        es.submit(mc);
    }
}
