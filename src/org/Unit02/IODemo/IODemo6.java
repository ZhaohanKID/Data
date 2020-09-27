package org.Unit02.IODemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 复制文件：
 *     分析：
 *          数据源 :将文件中的信息读取到Java程序中---FileInputStream
 *              a.txt
 *          目的地 :将内存中的信息写入b.txt中---FileOutputStream
 *              b.txt
 */

public class IODemo6 {
    public static void main(String[] args) throws IOException {
        //分别创建输入输出流
        FileInputStream fis = new FileInputStream("D:\\fis.txt");
        FileOutputStream fos = new FileOutputStream("D:\\fos.txt");

        //读写操作
        int content = 0;
        while ((content = fis.read()) != -1) {
            fos.write(content);
        }

        //释放资源
        fis.close();
        fos.close();
    }
}
