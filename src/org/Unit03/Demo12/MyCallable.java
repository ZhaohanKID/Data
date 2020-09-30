package org.Unit03.Demo12;

import java.util.concurrent.Callable;

/**
 * @Author: Z.HAN
 * @Date: 2020/9/27 15:59
 */
public class MyCallable implements Callable {
    @Override
    public Object call() throws Exception {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "---" + i);
        }
        return null;
    }
}
