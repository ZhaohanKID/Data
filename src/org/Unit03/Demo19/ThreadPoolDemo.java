package org.Unit03.Demo19;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *  线程池
 * @Author: Z.HAN
 * @Date: 2020/10/11 15:19
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        // 1 创建线程池对象
        ExecutorService es = Executors.newFixedThreadPool(2);
        // 2 创建自定义线程类的对象
        MyThreadPool mtp = new MyThreadPool();
        // 3 提交Runnable实例
        es.submit(mtp);
        es.submit(mtp);
        // 4 关闭线程池
        es.shutdown();
    }
}
