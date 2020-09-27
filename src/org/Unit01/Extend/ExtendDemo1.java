package org.Unit01.Extend;

public class ExtendDemo1 {
    public static void main(String[] args) {
        Person person = new Person("Hannah", 19);
        Student student = new Student();//实例化子类对象
        Student student1 = new Student("Andy", 40, "江华大学");
        student.setName("Allen");
        student.setAge(20);
        student.setSchool("西北大学");

        System.out.println(student.getName() + "\t" + student.getAge() + "\t" + student.getSchool());
        System.out.println(person.getName() + "\t" + person.getAge());

        student1.fun();
    }
}
class Person {
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
class Student extends Person {
    private String school;

    public Student() {
    }

    public Student(String name, int age, String school) {
        super(name, age);
        this.school = school;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public void fun() {
        System.out.println("父类中的name属性" + getName() + "\n父类中的age属性" + getAge());
    }
}
