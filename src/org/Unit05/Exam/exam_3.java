package org.Unit05.Exam;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Author: Z.HAN
 * @Date: 2020/10/12 12:36
 */
public class exam_3 {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while (true) {
            int num = sc.nextInt();
            arrayList.add(num);
            if (arrayList.size() == 3) {
                break;
            }
        }
    }
}
