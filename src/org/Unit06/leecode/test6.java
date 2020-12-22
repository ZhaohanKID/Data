package org.Unit06.leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author: Z.HAN
 * @ Date: 2020/12/22 8:30
 */
public class test6 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> permute = new Solution6().permute(nums);
        System.out.println(permute);
    }
}
class Solution6 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> track = new ArrayList<>(); // 记录路径
        backtrack(nums, track);
        return res;
    }
    public void backtrack(int[] nums, List<Integer> track) {
        if (track.size() == nums.length) {
            res.add(new ArrayList<>(track));
        }
        for (int i = 0; i < nums.length; i++) {
            if (track.contains(nums[i])) {
                continue;
            }
            track.add(nums[i]);
            backtrack(nums, track);
            track.remove(track.size() - 1);
        }
    }
}