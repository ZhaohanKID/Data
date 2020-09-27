package org.Unit01.string;

public class StringDemo8 {
    public static void main(String[] args) {
        /*String str = "heLloWoRLd";

        String str1 = str.substring(0, 1);
        String str2 = str.substring(1, 10);

        System.out.print(str1.toUpperCase());
        System.out.println(str2.toLowerCase());

        String str3 = "hello";
        String str4 = "hallo";
        System.out.println(str3.compareTo(str4));*/


        String str = "woshigangtiexiawoshizhendeshigangtiexia";
        int count = 0;
        while (str.indexOf("shi") != -1) {
            str = str.substring((str.indexOf("shi") + 2));
            count++;
        }
        System.out.println(count);

        StringBuffer sb = new StringBuffer();
        StringBuffer sb2 = new StringBuffer("hello");
        sb.append("hello");


    }
}
