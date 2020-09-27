package org.Unit01.Integer;

public class IntegerDemo1 {
    public static void main(String[] args) {
        Integer i = 10;//自动装箱
        i += 10;

        /*
            实际上是这样的：
            Integer i = Integer.valueOf(100);
            i = Integer.valueOf(i.intValue() + 998);
            System.out.println((new StringBuffer()).append(i).toString());
         */
    }
}
