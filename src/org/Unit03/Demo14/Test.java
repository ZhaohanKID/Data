package org.Unit03.Demo14;

/**
 * @Author: Z.HAN
 * @Date: 2020/10/9 15:36
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("代码块1");
        method();
        System.out.println("代码块2");
    }
    public static void method() {
        System.out.println("代码块3");
        function1();
        function2();
        System.out.println("代码块4");
    }

    private static void function1() {
    }
    private static void function2() {
    }
}
