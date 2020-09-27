package org.Unit01.obj;

public class personDemo2 {
    public static void main(String[] args) {
        Person2 per1 = new Person2(12, "张三");
        Person2 per2 = new Person2(23);
        /*per1.setAge(12);
        per1.setName("张三");*/
        per1.tell();
        per2.tell();

        System.out.println("-----------------------");
        //匿名对象
        new Person2(19, "Hannah").tell();
    }
}
class Person2 {
    //成员变量
    private String name;
    private int age;

    //构造方法
    //无参构造
    public Person2() {

    }
    //有参构造
    public Person2(int age, String name) {
        this.setAge(age);
        this.setName(name);
    }
    public Person2(int age) {
        this.setAge(age);
    }

    //get set 方法
    //取得姓名
    public String getName() {
        return name;
    }
    //设置姓名
    public void setName(String name) {
        this.name = name;
    }
    //取得年龄
    public int getAge() {
        return age;
    }
    //设置年龄
    public void setAge(int age) {
        if (age > 0 && age < 150) {
            this.age = age;
        }
    }

    public void tell() {
        System.out.println("姓名：" + this.getName() + "\n年龄：" + this.getAge());
    }
}
