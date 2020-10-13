package org.Unit03.Demo21;

import java.util.concurrent.Callable;

/**
 * @Author: Z.HAN
 * @Date: 2020/10/11 16:10
 */
public class MyCallable implements Callable<Integer> {
    private int num;

    public MyCallable(int num) {
        this.num = num;
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 1; i < num; i++) {
            sum += i;
        }
        return sum;
    }
}
