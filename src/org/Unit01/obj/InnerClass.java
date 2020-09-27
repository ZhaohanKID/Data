package org.Unit01.obj;

public class InnerClass {
    public static void main(String[] args) {
        new Outer.Inner().print();
    }
}
class Outer {
    private static String info = "hello world!";

    static class Inner {
        public void print() {
            System.out.println(info);
        }
    }
}
