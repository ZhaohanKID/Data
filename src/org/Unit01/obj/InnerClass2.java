package org.Unit01.obj;

public class InnerClass2 {
    public static void main(String[] args) {
        Outer1 outer1 = new Outer1();//实例化外部类对象
        Outer1.Inner1 inner1 = outer1.new Inner1();//实例化内部类对象
        inner1.print();//调用内部类方法
    }
}
class Outer1 {
    private String info = "hello world!";
    class Inner1 {
        public void print() {
            System.out.println(info);//直接访问外部类的私有属性
        }
    }
}
