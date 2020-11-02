package org.Unit06.leecode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author: Z.HAN
 * @Date: 2020/11/2 20:59
 */
public class test1 {
    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};

        Solution solution = new Solution();
        int[] nums3 = solution.intersection(nums1, nums2);
        System.out.println(Arrays.toString(nums3));
    }
}
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        // int[] nums3 = new int[maxSize]; 知道为什了，因为这样定义就使数组长度一定是4，没有定义的自然就是0 了，所以要用集合实现
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            for(int j = 0; j < nums2.length; j++) {
                if(nums1[i] == nums2[j]) {
                    if (!list.contains(nums1[i])) {
                        list.add(nums1[i]);
                    }
                }
            }
        }
        int[] nums3 = new int[list.size()];
        int k = 0;
        for (Integer num : list) {
            nums3[k] = num;
            k++;
        }
        return nums3;
    }
}
