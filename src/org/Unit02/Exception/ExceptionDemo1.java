package org.Unit02.Exception;

/**
 * 程序出现问题，控制台打印错误信息
 *      1、错误的包名，类名
 *      2、错误出现的位置
 *    这些信息是JVM做的，如果我们没有对异常进行处理，JVM会采用默认方式处理。
 *
 *      默认处理方式：
 *          1、打印错误信息
 *          2、结束程序
 *
 *
 *      try{
 *          //可能出现异常的语句
 *      } catch(异常类 变量名) {
 *          //针对异常的对象
 *      } finally {
 *          //一定会运行的代码
 *      }
 *   注意：try包含的代码越少越好，因为被try包裹的代码在执行时需要走异常处理机制，需要
 *       jvm分配新的资源去管理这些代码，所以包裹的代码越少越好。
 */

public class ExceptionDemo1 {
    public static void main(String[] args) {
        int a = 10;
        int b = 0;
        //把相应的错误信息提示出来
        try {
            System.out.println(a / b);
            System.out.println("此处代码不再执行");
        } catch (ArithmeticException ae) { //创建一个异常对象，捕获算术异常
            System.out.println("出现异常了：" + ae);
            System.out.println("除数不能是0");
        }
        System.out.println("程序结束");
    }
}
