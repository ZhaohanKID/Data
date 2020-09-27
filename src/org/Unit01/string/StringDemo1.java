package org.Unit01.string;

public class StringDemo1 {
    public static void main(String[] args) {
        /*String name1 = "Hannah";
        String name2 = new String("Hannah");
        System.out.println(name1 == name2);
        System.out.println(name1.equals(name2));*/

        /*String str = "hello";
        str = str + "world";
        System.out.println(str);*/

        String str1 = "hzit";
        for (int i = 0; i < 10; i++) {
            str1 += i;
        }
        System.out.println(str1);
    }
}
