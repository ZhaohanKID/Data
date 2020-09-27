package org.Unit01.Extend;

/**
 * 向上转型：
 *      子类对象 → 父类对象
 *      父类 父类对象 = 子类实例 ;
 */

public class PolDemo {
    public static void main(String[] args) {
        B1 b1 = new B1();
        A1 a1 = b1;
        /*
            上面的两步可以写为
            A1 a1 = new B1();
         */
        a1.fun1();//B-->public void fun1使用父类对象调用fun1方法，
        //但实际上调用的方法是被子类重写的过程

        a1.fun2();
    }
}
class A1 {
    public void fun1() {
        System.out.println("A-->public void fun1");
    }
    public void fun2() {
        this.fun1();
    }
}
class B1 extends A1 {
    public void fun1() {
        //此方法被子类重写了
        System.out.println("B-->public void fun1");
    }
    public void fun3() {
        System.out.println("B-->public void fun3");
    }
}
