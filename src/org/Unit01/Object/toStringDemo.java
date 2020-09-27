package org.Unit01.Object;

/**
 * Object类中的equals方法默认是比较地址的，并不能对其内容进行比较
 */

public class toStringDemo {
    public static void main(String[] args) {
        Demo demo1 = new Demo();
        System.out.println(demo1);
        System.out.println(demo1.toString());

        Demo demo2 = new Demo("Hannah", 19);
        System.out.println("对象信息：" + demo2);
        System.out.println(demo2.toString());
        //打印对象一定会调用toString方法

        System.out.println(demo2.hashCode());

        Demo demo3 = new Demo("Hannah", 19);
        System.out.println(demo2.equals(demo3) ? "true" : "false");
        System.out.println(demo2.equals("hello") ? "true" : "false");
    }
}
class Demo {
    private String name;
    private int age;

    public Demo() {

    }

    public Demo(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //重写equals方法
    public boolean equals(Object obj) {//这里对equals方法传递的参数是Object类型，所以任何对象都可以接受，所以下面要判断传入的对象是不是Demo对象
        if (this == obj) {
            return true;//地址相等，肯定是同一个对象
        }
        if (!(obj instanceof Demo)) {
            return false;//不是Demo对象
        }
        Demo demo = (Demo) obj;//向下转型
        if (demo.name.equals(this.name) && demo.age == this.age) {
            return true;
        } else {
            return false;
        }
    }

    //重写toString方法
    public String toString() {
        return "姓名：" + this.name + "\t年龄：" + this.age;
    }
}
