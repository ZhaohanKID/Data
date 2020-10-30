package org.Unit04.algorithm;

import java.util.Arrays;

/**
 *  字符串匹配之 KMP 算法
 * @Author: Z.HAN
 * @Date: 2020/10/29 22:22
 */
public class kmpDemo {
    public static void main(String[] args) {
        String str1 = "BBC ABCDAB ABCDABCDABDE";
        String str2 = "ABCDABD";

        int[] next = kmpNext("ABCDABD");
        int index = kmpSearch(str1, str2, next);

        System.out.println("next=" + Arrays.toString(next));
        System.out.println("index=" + index);
    }
    // kmp搜索算法
    public static int kmpSearch(String str1, String str2, int[] next) {
        // 遍历
        for (int i = 0, j = 0; i < str1.length(); i++) {
            // 需要处理不相等的情况
            while (j > 0 && str1.charAt(i) != str2.charAt(j)) {
                j = next[j - 1];
            }

            if (str1.charAt(i) == str2.charAt(j)) {
                j++;
            }
            if (j == str2.length()) {
                return i - j + 1;
            }
        }
        return -1;
    }

    // 获取到一个字符串(子串)的部分匹配表
    public static int[] kmpNext(String dest) {
        // 创建一个next数组保存部分匹配值
        int[] next = new int[dest.length()];
        next[0] = 0; // 如果字符串的长度是1，部分匹配值就是0
        for (int i = 0, j = 0; i < dest.length(); i++) {
            // 当charAt(i)不等于charAt(j)，需要从数组的上一个获取新的j
            while (j > 0 && dest.charAt(i) != dest.charAt(j)) {
                j = next[j - 1];
            }

            if (dest.charAt(i) == dest.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}
