package org.Unit01.Extend;

public class ExtendDemo2 {
    public static void main(String[] args) {
        Student1 student1 = new Student1();
        student1.print();
    }
}
class Person1 {
    void print() {
        System.out.println("父类方法");
    }
}
class Student1 extends Person1 {
    public void print() {
        super.print();
        System.out.println("子类方法");
    }
}
