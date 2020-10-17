package org.Unit03.Timer;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @Author: Z.HAN
 * @Date: 2020/10/13 21:52
 */
public class TimerDemo {
    public static void main(String[] args) {
        // 创建定时器对象
        Timer timer = new Timer();
        // 执行 Task 任务
        timer.schedule(new MyTask(timer), 3000);
    }
}
class MyTask extends TimerTask {
    private Timer timer;
    public MyTask(Timer timer) {
        this.timer = timer;
    }
    @Override
    public void run() {
        System.out.println("有内鬼，终止交易");
        timer.cancel();
    }
}
