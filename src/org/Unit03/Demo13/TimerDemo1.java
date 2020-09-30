package org.Unit03.Demo13;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 定时器：线程工具，可用于调度多个定时任务
 * @Author: Z.HAN
 * @Date: 2020/9/27 16:44
 */
public class TimerDemo1 {
    public static void main(String[] args) {
        Timer timer = new Timer();

        // timer.schedule(new MyTimer(), 3000);
        //timer.schedule(new MyTimer(), 3000, 1000);

        // 将定时器作为参数传递，任务结束后， 定时器就会停止。
        timer.schedule(new MyTimer(timer), 3000);
    }
}
class MyTimer extends TimerTask {
    private Timer timer;

    public MyTimer() {
    }

    public MyTimer(Timer timer) {
        this.timer = timer;
    }

    // 这里相当于我们要执行的任务。叫MyTask更好。
    @Override
    public void run() {
        System.out.println("duang~ 又发又黑又亮~");
        timer.cancel();
    }
}
