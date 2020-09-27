package org.Unit01.string;

public class StringDemo2 {
    public static void main(String[] args) {
        String str1 = "hello";
        System.out.println(str1.charAt(4));
        char c[] = str1.toCharArray();//将字符串变为字符数组
        for (int i = 0; i < c.length; i++) {
            System.out.print(c[i] + "\t");
        }

        System.out.println();
        String str2 = new String(c);//将全部字符数组变为字符串 hello
        String str3 = new String(c, 1, 3);//将部分字符数组变为字符串hel

        System.out.println(str2);
        System.out.println(str3);
    }
}
