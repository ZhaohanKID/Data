package org.Unit01.Regex;

import java.util.Scanner;

public class RegexDemo2 {
    public static void main(String[] args) {
        String s = "[1-9][0-9]{4,14}";
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入您的QQ号：");
        String s1 = sc.next();

        if (s1.matches(s)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
