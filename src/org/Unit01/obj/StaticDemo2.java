package org.Unit01.obj;

/**
 * 使用static为对象进行编名操作
 */

public class StaticDemo2 {
    public static void main(String[] args) {
        System.out.println(new Demo().getName());
        System.out.println(new Demo("HZJT").getName());
        System.out.println(new Demo().getName());
        System.out.println(new Demo("HZIT").getName());
        System.out.println(new Demo().getName());
    }
}
class Demo {
    private String name;
    private static int count = 0;

    public Demo() {
        count++;//只要有对象产生就进行自增
        this.name = "DEMO-" + count;
    }

    public Demo(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
