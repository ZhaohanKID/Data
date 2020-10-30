package org.Unit04.algorithm;

/**
 *  字符串匹配之暴力匹配算法
 * @Author: Z.HAN
 * @Date: 2020/10/29 22:06
 */
public class ViolenceMatchDemo {
    public static void main(String[] args) {
        String str1 = "我是钢铁侠 我真的是钢铁侠我就是钢 我就是钢铁侠欧耶欧耶";
        String str2 = "就是钢铁侠";

        int index = violenceMatch(str1, str2);
        System.out.println("index = " + index);
    }
    public static int violenceMatch(String str1, String str2) {
        char[] c1 = str1.toCharArray();
        char[] c2 = str2.toCharArray();

        int s1Len = c1.length;
        int s2Len = c2.length;

        int i = 0;
        int j = 0;
        while (i < s1Len && j < s2Len) {
            if (c1[i] == c2[j]) {
                i++;
                j++;
            } else {
                i = i - (j - 1);
                j = 0;
            }
        }
        if (j == s2Len) {
            return i - j;
        } else {
            return -1;
        }
    }
}
