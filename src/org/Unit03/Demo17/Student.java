package org.Unit03.Demo17;

/**
 *  特点：高内聚，低耦合，所以要将方法直接封装到该类中
 * @Author: Z.HAN
 * @Date: 2020/10/11 10:21
 */
public class Student {
    private String name;
    private int age;
    private boolean flag = false;
    public Student(){

    }
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public synchronized void set(String name, int age) {
        if (flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.name = name;
        this.age = age;

        this.flag = true;
        this.notify();
    }
    public synchronized void get() {
        if (!this.flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(this.name + "---" + this.age);

        this.flag = false;
        this.notify();
    }
}
