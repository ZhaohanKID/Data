package org.Unit01.string;

public class StringDemo4 {
    public static void main(String[] args) {
        String str1 = "  abcdefcsgh  ";
        String str2 = "hello world";
        System.out.println(str1.indexOf("c"));
        System.out.println(str1.indexOf("c", 3));
        System.out.println("x");

        System.out.println("bc");//看来不能查找字符串
        System.out.println("ce");

        //去掉左右空格
        System.out.println(str1.trim());

        //字符串截取
        System.out.println(str2.substring(4));
        System.out.println(str2.substring(1, 7));

        System.out.println("-------------------------------");

        //字符串拆分
        String s[] = str2.split("l");
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);//h      llo world
        }

        System.out.println("-------------------------------");

        //判断是否以指定的字符串开头或结尾
        if (str2.startsWith("he")) {
            System.out.println("yes");
        }

        //不区分大小写进行字符串比较
        String str3 = "Hello World";
        System.out.println(str2.equals(str3));
        System.out.println(str2.equalsIgnoreCase(str3));

        //将一个指定的字符串替换成其他字符串
        String newStr = str3.replace("l", "x");
        System.out.println(newStr);
    }
}
