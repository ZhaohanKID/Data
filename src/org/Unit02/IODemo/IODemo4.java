package org.Unit02.IODemo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *  IO流异常处理：
 *
 */

public class IODemo4 {
    public static void main(String[] args) {
        //创建字节输出流对象
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("D:\\fos.txt");
            //写入数据
            fos.write("hello".getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {//必须有释放资源这一步，所以要写到finally里面
            //解决空指针问题
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
