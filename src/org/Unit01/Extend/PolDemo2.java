package org.Unit01.Extend;

/**
 * 向下转型：
 *      父类对象 → 子类对象
 *      子类 子类对象 = (子类) 父类实例 ;
 *
 *      在进行对象的向下转型前，必须首先发生对象向上转型，否则将出现对象转换异常
 */

public class PolDemo2 {
    public static void main(String[] args) {
        /*A2 a2 = new B2();
        B2 b2 = (B2) a2;
        b2.fun1();
        b2.fun2();
        b2.fun3();*/

        A2 a2 = new B2();
        //通过子类实例化的对象同时是子类和父类的实例
        System.out.println(a2 instanceof A2);//true
        System.out.println(a2 instanceof B2);//true

        A2 a21 = new A2();
        System.out.println(a21 instanceof A2);//true
        System.out.println(a21 instanceof B2);//false
    }
}
class A2 {
    public void fun1() {
        System.out.println("A-->public void fun1");
    }
    public void fun2() {
        this.fun1();
    }
}
class B2 extends A2 {
    public void fun1() {
        //此方法被子类重写了
        System.out.println("B-->public void fun1");
    }
    public void fun3() {
        System.out.println("B-->public void fun3");
    }
}
