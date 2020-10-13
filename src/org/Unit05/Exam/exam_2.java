package org.Unit05.Exam;

import java.util.Scanner;

/**
 * @Author: Z.HAN
 * @Date: 2020/10/11 13:54
 */
public class exam_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String str = Integer.toBinaryString(num);
        char[] chars = str.toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '1') {
                count++;
            }
        }
        System.out.println(count);
    }
}
