package org.Unit01.Regex;

import java.util.Scanner;

/**
 * 校验QQ号码
 */

public class RegexDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入QQ号：");
        String qq = sc.next();

        if (checkQQ(qq)) {
            System.out.println("输入正确");
        } else {
            System.out.println("输入错误");
        }
    }
    public static boolean checkQQ(String qq) {
        if (qq.length() >= 5 && qq.length() <= 15) {
            if (!qq.startsWith("0")) {
                char[] chars = qq.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    if (!Character.isDigit(chars[i])) {
                        return false;
                    }
                }
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
