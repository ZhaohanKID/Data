package org.Unit05.Exam;

/**
 *  给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 * @Author: Z.HAN
 * @Date: 2020/10/12 12:42
 */
public class exam_4 {
    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "345";
        String res = add(num1, num2);
        System.out.println(res);
    }
    public static String add(String num1, String num2) {
        int index1 = num1.length() - 1;
        int index2 = num2.length() - 1;
        if (num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0) {
            return "";
        }
        StringBuilder stb = new StringBuilder();
        int carry = 0;
        int temp1 = 0;
        int temp2 = 0;
        int sum = 0;
        while (index1 >= 0 || index2 >= 0) {
            if (index1 < 0) {
                temp1 = 0;
            } else {
                // 减0，将字符0转换为数字0
                temp1 = num1.charAt(index1--) - '0';
            }
            if (index2 < 0) {
                temp2 = 0;
            } else {
                temp2 = num2.charAt(index2--) - '0';
            }
            sum = temp1 + temp2 + carry;
            stb.append(sum % 10);
            carry = sum / 10;
        }
        if (carry == 1) {
            stb.append(1);
        }
        return stb.reverse().toString();
    }
}
