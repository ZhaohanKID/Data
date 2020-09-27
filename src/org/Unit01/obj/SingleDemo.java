package org.Unit01.obj;

/**
 * 单例设计模式：
 *      无论程序怎样运行，Singleton类永远只会有一个实例化对象
 *      栈内存中有instance s1 s2 ， 但指向的都是同一个堆内存，也即只有一个实例化对象
 */

public class SingleDemo {
    public static void main(String[] args) {
        //通过静态方法取得Singleton类的实例
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        s1.print();
        s2.print();
    }
}
class Singleton {
    //在内部产生本类的实例化对象，将属性封装
    private static Singleton instance = new Singleton();

    private Singleton() {//将构造方法封装

    }

    public static Singleton getInstance() {//通过静态方法取得Singleton类的实例
        return instance;
    }

    public void print() {
        System.out.println("hello world!");
    }
}

