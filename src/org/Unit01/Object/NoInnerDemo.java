package org.Unit01.Object;

public class NoInnerDemo {
    public static void main(String[] args) {
        new X().fun1();
    }
}
interface A {
    public void printInfo();//定义抽象方法
}
class X {
    public void fun1() {
        this.fun2(new A() {
            public void printInfo() {
                System.out.println("hello world!");
            }
        });
    }
    public void fun2(A a) {
        a.printInfo();
    }
}
