package org.Unit03.Demo16;

/**
 * @Author: Z.HAN
 * @Date: 2020/10/11 10:21
 */
public class Student {
    private String name;
    private int age;
    public boolean flag = false;
    public Student(){

    }
    public Student(String name, int age) {
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
