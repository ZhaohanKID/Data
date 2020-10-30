package org.Unit04.dataStructure.Recursion;

/**
 * @Author: Z.HAN
 * @Date: 2020/10/24 14:38
 */
public class RecursionTest {
    public static void main(String[] args) {
        method(4);

        System.out.println(factorial(5));
    }
    // 打印问题 加else 与 不加else不一样
    public static void method(int n) {
        if(n > 1) {
            method(n - 1);
        }
        System.out.println("n = " + n);
    }
    // 求阶乘
    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return factorial(n - 1) * n;
        }
    }
}
