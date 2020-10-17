package org.Unit05.Exam;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Z.HAN
 * @Date: 2020/10/12 12:36
 */
public class exam_3 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Sol sol = new Sol();
        List<List<Integer>> list = sol.permute(nums);
        System.out.println(list);
    }
}
class Sol{
    List<List<Integer>> res = new ArrayList<List<Integer>>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return res;
        }
        backtrack(nums, new ArrayList<Integer>());
        return res;
    }

    private void backtrack(int[] nums, List<Integer> tmp) {
        if (tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (tmp.contains(nums[i])) {
                continue;
            }
            tmp.add(nums[i]);
            backtrack(nums, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}
