package org.Unit06.leecode;

/**
 * @ Author: Z.HAN
 * @ Date: 2020/12/21 21:02
 */
public class test5 {
    public static void main(String[] args) {
        int[] nums = {1};
        int index = Solution5.dominantIndex(nums);
        System.out.println(index);
    }
}
class Solution5 {
    public static int dominantIndex(int[] nums) {
        /*
            评论区有个人说的对，为什么一定要拿最大值与每一个值比较呢？
            找出来次大值，只要次大值的二倍小于等于最大值不就行了吗？

            这个赋初值也不是随便赋的。。。
         */
        int index = 0;
        int first = 0;
        int second = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > first) {
                second = first;
                first = nums[i];
                index = i;
            } else if (nums[i] > second) {
                second = nums[i];
            }
        }
        return (first >= 2 * second) ? index : -1;
    }
}
