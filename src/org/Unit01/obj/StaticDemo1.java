package org.Unit01.obj;

public class StaticDemo1 {
    public static void main(String[] args) {
        Person3 p1 = new Person3("张三", 20);
        Person3 p2 = new Person3("李四", 29);
        Person3 p3 = new Person3("赵六", 19);
        p1.info();
        p2.info();
        p3.info();
    }
}
class Person3 {
    String name;
    int age;
    String country = "深圳";

    public Person3(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void info() {
        System.out.println("姓名：" + this.name + "\t年龄：" + this.age + "\t城市：" + country);
    }
}
