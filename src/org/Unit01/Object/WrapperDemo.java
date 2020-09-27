package org.Unit01.Object;

/**
 * Object类中的equals方法默认是比较地址的，并不能对其内容进行比较
 */

public class WrapperDemo {
    public static void main(String[] args) {
        int x = 30;
        Integer integer = new Integer(x);//装箱：将基本数据类型变为包装类
        int temp = integer.intValue();//拆箱：将一个包装类变为基本数据类型

        System.out.println(integer);
        System.out.println(temp);


        System.out.println("----------------------");
        String str1 = "300";
        String str2 = "30.34";
        int y = Integer.parseInt(str1);//将字符串变为int型
        float f = Float.parseFloat(str2);//将字符串变为float型
        System.out.println(x + "\t" + x + "\t" + (x * x));
        System.out.println(f + "\t" + f + "\t" + (f * f));
    }
}
