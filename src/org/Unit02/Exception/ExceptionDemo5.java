package org.Unit02.Exception;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExceptionDemo5 {
    public static void main(String[] args) {
        method();
    }

    public static void method() {
        int a = 1;
        int b = 0;
        if (b == 0) {
            throw new ArithmeticException();
        } else {
            System.out.println(a / b);
        }
    }
}
