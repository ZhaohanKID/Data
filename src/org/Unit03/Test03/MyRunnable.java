package org.Unit03.Test03;

public class MyRunnable implements Runnable {
    private static String winner; // 胜利者
    // 这个可以不加static？？？？为什么？？

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            // 模拟兔子的休息
            if (Thread.currentThread().getName().equals("兔子") && i % 10 == 0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println(Thread.currentThread().getName() + "--->" + i);
            boolean flag = gameOver(i); // 每走一步都要判断比赛是否结束。
            if (flag) {
                break;
            }
        }
    }

    private boolean gameOver(int steps) {
        if (winner != null) { // 存在胜利者。
            return true;
        } else {
            if (steps == 100) {
                winner = Thread.currentThread().getName();
                System.out.println("winner:" + winner);
                return true;
            }
        }
        return false;
    }
}
