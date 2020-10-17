package org.Unit05.Exam;

import java.util.Scanner;

/**
 * @Author: Z.HAN
 * @Date: 2020/10/11 13:54
 */
public class exam_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char[] chars = str.toCharArray();
        reverse(chars);
        for (int i = 0; i < chars.length; i++) {
            if (i == 0) {
                System.out.print("[" + chars[i] + ",");
            } else if (i == chars.length - 1) {
                System.out.print(chars[i] + "]");
            } else {
                System.out.print(chars[i] + ",");
            }
        }
    }
    public static void reverse(char[] chars) {
        int low = 0;
        int high = chars.length - 1;
        while (low < high) {
            char temp = chars[low];
            chars[low] = chars[high];
            chars[high] = temp;
            low++;
            high--;
        }
    }
}
