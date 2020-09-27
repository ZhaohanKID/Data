package org.Unit02.IODemo;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 *      1.如何实现换行
 *          \n
 *          不同的操作系统，他的换行符是不一样的，
 *          Windows的换行符：\r\n现在也支持\n了
 *          Linux：\n
 *          Mac：\n
 *      2.如何实现追加
 *          构造方法中增加一个布尔型参数即可
 */

public class IODemo3 {
    public static void main(String[] args) throws IOException {
        //创建字节流对象
        FileOutputStream fos = new FileOutputStream("D:\\fos.txt", true);
        //写数据
        for (int i = 0; i < 10; i++) {
            fos.write(("helloJava" + i).getBytes());
            fos.write("\n".getBytes());
        }
        //释放资源
        fos.close();
    }
}
