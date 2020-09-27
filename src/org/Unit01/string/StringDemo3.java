package org.Unit01.string;

public class StringDemo3 {
    public static void main(String[] args) {
        String str1 = "HelloWorld";
        byte b[] = str1.getBytes();//将字符串变为byte数组

        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + "\t");
        }
        System.out.println();
        System.out.println(str1.length());

        System.out.println(new String(b));//将全部byte数组变为字符串
        System.out.println(new String(b, 1, 3));
    }
}
