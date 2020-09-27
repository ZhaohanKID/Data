package org.Unit02.Exception;

public class ExceptionDemo2 {
    public static void main(String[] args) {
        int a = 1;
        int b = 0;
        int[] c = {1, 2, 3};

        try {
            System.out.println(a / b);
            System.out.println(c[3]);
        } catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
            System.out.println("有异常");
        }
        System.out.println("程序结束！");

        /*try {
            System.out.println(a / b);
            System.out.println(c[3]);
        } catch (ArithmeticException e) {
            System.out.println("除数不能为0");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("数组越界");
        }*/
    }
}
