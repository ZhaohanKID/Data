package org.Unit03.Demo12;

import java.util.concurrent.Callable;

/**
 * @Author: Z.HAN
 * @Date: 2020/9/27 16:04
 */
public class MyCallable2 implements Callable<Integer> {
    private int num;

    public MyCallable2(int num) {
        this.num = num;
    }

    @Override
    public Integer call() throws Exception {
        int result = 0;
        for (int i = 0; i <= num; i++) {
            result += i;
        }
        return result;
    }
}
