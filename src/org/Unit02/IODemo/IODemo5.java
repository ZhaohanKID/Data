package org.Unit02.IODemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 字节输入流操作：
 *      1.创建字节输入流对象
 *      2.读取数据
 *      3.释放资源
 *
 *    构造方法
 */

public class IODemo5 {
    public static void main(String[] args) throws IOException {
        //创建字节输入流对象
        FileInputStream fis = new FileInputStream("D:\\fos.txt");
        /*//读取数据
        int content = fis.read();
        System.out.println((char)content);
        //我们可以使用循环来读取文件中的数据，如何控制循环的次数

        //通过多次读取，我们发现read方法有点像迭代器的next()方法*/

        //优化一：
        /*int content = fis.read();
        while (content != -1) {
            System.out.print((char)content);
            content = fis.read();
        }*/

        //优化二：
        int content = 0;
        while ((content = fis.read()) != -1) {
            System.out.print((char)content);
        }
    }
}
