package org.Unit02.IODemo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 概述：
 *      因为我们要将有用的信息存储到硬盘上，这个过程需要我们学习一个技术：IO流
 *
 *      流：本身是一个抽象概念，它是对数据传输的总称，也就是说，数据在设备间的传输，
 *      叫做流。I-input     O-output把内存的东西写到硬盘中
 *
 *      1、明确操作是读还是写
 *      2、使用何种类型的流
 *
 *
 * 铺垫技术：
 *      1、异常处理
 *      2、File类
 *
 *
 *     异常：因为在介质间传输可能会遇到一些问题，比如文件格式异常，文件读写错误，我们要知道怎么去处理这些异常
 *
 *
 *  IO流的分类：
 *      流向
 *          输入流
 *          输出流
 *      数据类型
 *          字节流
 *              字节输入流inputStream
 *              字节输出流OutputStream
 *          字符流
 *              字符输入流Reader
 *              字符输出流Writer
 *
 *      注意：一般我们在说流的分类时都是按照数据类型来分
 *      练习：使用IO流将'helloworld’写入到文件里
 *      分析：
 *          1、虽然我们可以使用字符流，但是字节流先于字符流出现，所以先学习字节流
 *          2、此需求要求将内存中的数据写入到硬盘中，所以我们选择使用输出流
 *
 *     通过上面的分析，我们知道我们可以使用字节输出流，OutputStream
 *     但是OutputStream是一个抽象类，所以他无法实例化
 *     所以我们要使用他的一个具体实现的子类，
 *     FileOutputStream 将字节流写入到File
 *
 *     注意：IO流这一章，我们学习的具体的子类都是以父类的类名作为后缀
 *        字节流
 *              xxxOutputStream
 *              xxxInputStream
 *        字符流
 *              xxxWriter
 *              xxxReader
 *
 *      构造方法：
 *          public FileOutputStream(File file)
 *          public FileOutputStream(String str)
 *
 *       字节输出流操作步骤：
 *          1.创建字节输出流对象
 *          2.写数据
 *          3.释放资源
 */

public class IODemo1 {
    public static void main(String[] args) throws IOException {
        //创建字节输出流对象
        //1.public FileOutputStream(File file)
        File file = new File("D:\\fos.txt");
        FileOutputStream fos = new FileOutputStream(file);

        //2.public FileOutputStream(String str)
        FileOutputStream fos2 = new FileOutputStream("D:\\fos.txt");


        /*
            创建字节输出流：
                1.创建File对象
                2.创建文件
                3.创建字节输出流对象
                4.将字节输出流对象指向该文件
         */

        //写入数据：public void write(byte[] b)
        fos.write("HelloWorld".getBytes());
        //释放资源
        //关闭此字节输出流并释放与流相关的所有系统资源，此字节输出流不能再用于写入数据
        fos.close();
        /*
            为什么要关闭流：
                1.让流对象变成垃圾，这样就会被垃圾回收器回收
                2.通知系统去释放与该流相关的所有资源
         */
    }
}
