package org.Unit06.leecode;

import javax.management.MBeanAttributeInfo;

/**
 * @Author: Z.HAN
 * @Date: 2020/12/21 19:40
 */
public class test4 {
    public static void main(String[] args) {
        int[] dp = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        int res = Solution4.minCostClimbingStairs(dp);
        System.out.println(res);
    }
}
class Solution4 {
    public static int minCostClimbingStairs(int[] cost) {
        int l = cost.length;
        int[] dp = new int[l + 1];

        for (int i = 2; i <= l; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[l];
    }
}
