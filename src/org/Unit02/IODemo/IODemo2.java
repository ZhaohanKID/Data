package org.Unit02.IODemo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *  FileOutputStream 写入的方法
 *      public void write(byte[] b)
 *      public void write(byte[] b, int off, int len)
 *      public void write(int b)
 *
 *    字节输出流操作步骤：
 *      1.创建字节流对象
 *      2.写数据
 *      3.释放资源
 */

public class IODemo2 {
    public static void main(String[] args) throws IOException{
        //创建字节流对象
        FileOutputStream fos = new FileOutputStream("D:\\fos.txt");

 /*       //写数据
        //1.public void write(int b)
        fos.write(97);

        fos.write(57);//重新写的内容
        fos.write(55);*/

        //2.public void write(byte[] b)
        byte[] bytes = {97, 98, 99, 100, 101};
        //byte[] bytes1 = {'a', 'b', 'c'};
        fos.write(bytes);//abcde

        //3.public void write(byte[] b, int off, int len)
        fos.write(bytes, 1, 2);//abcdebc


        //释放资源
        fos.close();
    }
}
