package org.Unit04.dataStructure.Recursion;

/**
 *  八皇后问题
 * @Author: Z.HAN
 * @Date: 2020/10/24 16:22
 */
public class Queue8 {
    int max = 8; // 定义有几个皇后
    int[] array = new int[max]; // 定义一个数组，存放最终皇后的位置
    static int count = 0;
    static int judgeCount = 0;

    public static void main(String[] args) {
        // 测试
        Queue8 queue8 = new Queue8();
        queue8.check(0);

        System.out.println("一共有" + count + "种解法");
        System.out.println("一共判断了" + judgeCount + "次");
    }

    /**
     *  判断第n个皇后和前面n-1个皇后是否有冲突
     * @param n 表示第 n 个皇后
     * @return
     */
    private boolean judge(int n) {
        judgeCount++;
        for (int i = 0; i < n; i++) {
            // 判断第n个皇后和前面n-1个皇后是否有冲突，同一列 或者 同一斜线
            // 位于同一斜线的行数之差的绝对值等于列数之差的绝对值，也就是两个之间相差两行则一定相差两列
            // n 就代表行，就没必要再判断是否位于同一行了
            if (array[n] == array[i] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }

    // 编写一个方法，放置第 n 个皇后
    private void check(int n) {
        if (n == max) { // n = 8,要放第九个皇后了，也就是前8个皇后已经放好了
            print();
            return;
        }
        // 依次放入皇后，判断是否冲突
        for (int i = 0; i < max; i++) {
            // 先把当前这个皇后n 放置到该行的第一列
            array[n] = i;
            // 判断当前这个皇后放置到第 i 列时是否冲突
            if (judge(n)) { // 不冲突，继续放下一个皇后
                check(n + 1);
            }
            // 如果冲突，就继续执行 array[n]=i，即将第 n 个皇后放置在本行的后一个位置
        }
    }

    private void print() {
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
