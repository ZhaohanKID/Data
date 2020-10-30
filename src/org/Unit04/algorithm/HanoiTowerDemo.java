package org.Unit04.algorithm;

/**
 *  利用分治算法解决汉诺塔问题
 * @Author: Z.HAN
 * @Date: 2020/10/29 21:54
 */
public class HanoiTowerDemo {
    public static void main(String[] args) {
        hanoiTower(3, 'A', 'B', 'C');
    }
    public static void hanoiTower(int num, char a, char b, char c) {
        if (num == 1) {
            System.out.println("第1个盘从" + a + "->" + c);
        } else {
            // 先把 num - 1 个盘从A移动到B 其中要借助c实现
            hanoiTower(num - 1, a, c, b);
            // 然后再把最后一个从A移动到C
            System.out.println("第" + num + "个盘从" + a + "->" + c);
            // 再把B上的num-1个从B移动到C
            hanoiTower(num - 1, b, a, c);
        }
    }
}
