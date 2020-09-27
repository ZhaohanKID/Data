package org.Unit01.Extend;

/**
 * 子类重写了抽象方法，然后在主方法中通过子类的实例化对象就可以调用被子类重写过的方法
 */

public class AbstractDemo {
    public static void main(String[] args) {
        B b = new B();
        b.print();
    }
}
abstract class A {
    public static final String FLAG = "CHINA";
    private String name = "张三";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //抽象方法
    public abstract void print();
}
class B extends A {
    //继承抽象类，因为B是普通类，所以此类的声明为abstract class
    public void print() {
        System.out.println("FLAG = " + FLAG);
        System.out.println("姓名 = " + super.getName());
    }
}
