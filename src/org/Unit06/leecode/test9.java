package org.Unit06.leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author: Z.HAN
 * @ Date: 2020/12/22 20:49
 */
public class test9 {
    public static void main(String[] args) {
        int fibonacci = Solution9.Fibonacci(5);
        System.out.println(fibonacci);

        int solution = Solution9.Sum_Solution(5);
        System.out.println(solution);
    }
}
class Solution9 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        return list;
    }

    public static int Fibonacci(int n) {
        int f1 = 1;
        int f2 = 1;
        int fn = 0;
        for (int i = 0; i < n - 2; i++) {
            fn = f1 + f2;
            f1 = f2;
            f2 = fn;
        }
        if (n == 0) {
            return  0;
        } else if (n <= 2) {
            return 1;
        } else {
            return fn;
        }
    }

    public static int Sum_Solution(int n) {
        // return (1 + n) * n / 2;
        /*if (n == 1) {
            return 1;
        } else {
            return Sum_Solution(n - 1) + n;
        }*/
        /*
        失败啊，不能使用乘法，也不能出现if
         */
        boolean x = (n > 0) && ((n += Sum_Solution(n - 1)) > 0);
        return n;
    }
    public static int Sum_Solution2(int n) {
        int sum = n;
        boolean flag = (sum > 0) && ((sum += Sum_Solution(--n)) > 0);
        return sum;
    }

}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
