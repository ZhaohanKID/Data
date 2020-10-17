package org.Unit05.Exam;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Z.HAN
 * @Date: 2020/10/13 18:20
 */
public class exam_7 {
    public static void main(String[] args) {
        int[] arr = {2, 3, 6, 7};
        Solve solve = new Solve();
        List<List<Integer>> list = solve.sum(arr, 7);
        System.out.println(list);
    }
}
class Solve {
    List<List<Integer>> res = new ArrayList<List<Integer>>();

    public List<List<Integer>> sum(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrack(candidates, target, list);
        return lists;
    }
    public void backtrack(int[] candidates, int target, List<Integer> list) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        } else if (target < 0){
            return;
        }
        for (int i = 0; i < candidates.length; i++) {
            list.add(candidates[i]);
            backtrack(candidates, target - candidates[i], list);
            list.remove(list.size() - 1);
        }
    }
}
