package org.Unit02.Exception;


import java.util.Scanner;

public class StudentDemo {
    public static void main(String[] args) {
        //创建Scanner对象
        Scanner sc = new Scanner(System.in);
        //接收用户输入的数据
        System.out.println("请输入成绩：");
        int score = sc.nextInt();
        //校验成绩
        Teacher teacher = new Teacher();
        try {
            teacher.checkScore(score);
        } catch (MyException e) {
            e.printStackTrace();
        }
        System.out.println("程序结束");
    }
}

class Teacher {
    public void checkScore(int score) throws MyException {
        if (score < 0 || score > 100) {
            throw new MyException("成绩必须在0-100之间");
        } else {
            System.out.println("您输入的成绩合法！");
        }
    }
}

class MyException extends Exception {
    //构造方法
    //无参构造
    public MyException() {
    }
    //指定有参构造
    public MyException(String message) {
        super(message);//调用Exception类中有一个参数的构造方法，传递错误信息
    }
}
