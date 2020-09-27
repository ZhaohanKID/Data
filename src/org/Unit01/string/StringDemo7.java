package org.Unit01.string;

public class StringDemo7 {
    public static void main(String[] args) {
        Demo1 d1 = new Demo1();
        d1.temp = "world";
        System.out.println(d1.temp);
        fun(d1);
        System.out.println(d1.temp);
    }
    public static void fun(Demo1 d2) {
        d2.temp = "Java";
    }
}
class Demo1 {
    String temp = "hello";
}
