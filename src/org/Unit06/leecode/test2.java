package org.Unit06.leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Z.HAN
 * @Date: 2020/11/7 13:50
 */
public class test2 {
    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int res = solution2.reverse(-123);
        System.out.println(res);
    }
}
class Solution2 {
    public int reverse(int x) {
        List<Integer> list = new ArrayList<>();
        if (x < 0) {
            x = -x;
            while (x > 0) {
                list.add(x % 10);
                x /= 10;
            }
            int res = 0;
            for (int i = 0; i < list.size(); i++) {
                res = res * 10 + list.get(i);
            }
            if (res >= -Math.pow(2, 31) && res <= Math.pow(2, 31) - 1) {
                return -res;
            } else {
                return 0;
            }
        } else {
            while (x > 0) {
                list.add(x % 10);
                x /= 10;
            }
            int res = 0;
            for (int i = 0; i < list.size(); i++) {
                res = res * 10 + list.get(i);
            }
            if (res >= -Math.pow(2, 31) && res <= Math.pow(2, 31) - 1) {
                return res;
            } else {
                return 0;
            }

        }

    }
}