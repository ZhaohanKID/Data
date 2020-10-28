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

    public List<List<Integer>> sum(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList();
        List<Integer> list = new ArrayList();
        backTracking(candidates, 0, target, lists, list);
        return lists;
    }

    public void backTracking(int[] candidates, int start, int target, List<List<Integer>> lists, List<Integer> list) {
        if (target == 0) {
            lists.add(new ArrayList(list));
            return;
        } else if (target < 0) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            list.add(candidates[i]);
            backTracking(candidates, i, target - candidates[i], lists, list);
            list.remove(list.size() - 1);
        }
    }
}
