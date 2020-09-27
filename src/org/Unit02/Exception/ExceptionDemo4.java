package org.Unit02.Exception;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExceptionDemo4 {
    public static void main(String[] args) {
        //method();
        try {
            method1();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("程序结束！");
    }

    //运行时异常
    public static void method() throws ArithmeticException {
        int a = 1;
        int b = 0;
        System.out.println(a / b);
    }

    //编译时异常
    public static void method1() throws ParseException {
        String s = "2020-8-16";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = sdf.parse(s);
        System.out.println(date);
    }
}
