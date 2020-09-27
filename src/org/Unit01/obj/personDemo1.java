package org.Unit01.obj;

public class personDemo1 {
    public static void main(String[] args) {
/*        Person1 per1 = new Person1();//创建并实例化对象
        Person1 per2 = per1;
        per1.name = "张三";//为 name 属性赋值
        per1.age = 15;//为 age 属性赋值
        per2.name = "李四";*/

        Person1 per1 = new Person1();
        Person1 per2 = new Person1();
        per1.name = "张三";
        per1.age = 23;
        per2.name = "李四";
        per2.age = 34;
        per2 = per1;//将per1的引用传递给per2,最终两个对象的输出结果都是 张三 23

        System.out.println("per1对象中的内容：");
        per1.tell();//调用类中的方法
        System.out.println("per2对象中的内容：");
        per2.tell();
    }
}
class Person1 {
    String name;
    int age;

    public void tell() {
        System.out.println("姓名：" + name + "\n" + "年龄：" + age);
    }
}
