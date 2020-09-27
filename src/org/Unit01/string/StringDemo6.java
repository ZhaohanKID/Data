package org.Unit01.string;

public class StringDemo6 {
    public static void main(String[] args) {
        String str1 = "hello";
        System.out.println(str1);
        fun(str1);
        System.out.println(str1);
    }
    public static void fun(String str2) {
        str2 = "world";
    }
}
