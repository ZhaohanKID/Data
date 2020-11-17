package org.Unit06.leecode;

/**
 * 假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花卉不能种植在相
 * 邻的地块上，它们会争夺水源，两者都会死去。
 * 给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个
 * 数 n 。能否在不打破种植规则的情况下种入 n 朵花？能则返回True，不能则返回False。
 * @Author: Z.HAN
 * @Date: 2020/11/17 7:59
 */
public class test3 {
    public static void main(String[] args) {
        int[] flowerbed = {1,0,0,0,1};
        System.out.println(new Flower().canPlaceFlowers(flowerbed, 1));
    }
}
class Flower {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
/*        int num = 0;
        int count = 1; // 给最左边第一个元素前面置0，这样可以不专门考虑边界元素
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                count++;
            } else {
                count = 0;
            }
            if (count == 3) {
                num++;
                count = 1;
            }
        }
        if (count == 2) {
            num++;
        }
        return n <= num;*/

        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                count++;
                flowerbed[i] = 1;
            }
        }
        return count >= n;
    }
}
