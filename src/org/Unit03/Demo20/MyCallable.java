package org.Unit03.Demo20;

import java.util.concurrent.Callable;

/**
 * @Author: Z.HAN
 * @Date: 2020/10/11 15:41
 */
public class MyCallable implements Callable {
    @Override
    public Object call() throws Exception {
        for (int i = 0; i < 30; i++) {
            System.out.println(i);
        }
        return null;
    }
}
