package org.Unit01.obj;

public class mainDemo1 {
    public static void main(String[] args) {
        /*if (args.length != 3) {
            System.out.println("输入参数的个数不足三个，程序退出");
            System.exit(1);
        }*/

        //普通代码块
        /*{
            int x = 30;
            System.out.println("普通代码块 x=" + x);//30
        }
        int x = 40;
        System.out.println("代码块之外 x=" + x);//40*/

        /*new Demo1();//1、构造块
                    //2、构造方法
        new Demo1(); //1、构造块
                    //2、构造方法*/
        //由此可见，构造块优先于构造方法执行而且每次实例化对象时都会执行构造块中的代码


    }
}
//构造块
/*
class Demo1 {
    {
        //定义构造块
        System.out.println("1、构造块");
    }

    public Demo1() {
        System.out.println("2、构造方法");
    }
}*/
