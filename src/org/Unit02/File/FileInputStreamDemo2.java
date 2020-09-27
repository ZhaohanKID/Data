package org.Unit02.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamDemo2 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("D:\\各种作业\\1.txt");
        byte[] bytes = new byte[5];

        //第一次读取
        int length = fis.read(bytes);
        System.out.println(new String(bytes));

        //第二次读取
        length = fis.read(bytes);
        System.out.println(new String(bytes));

        //第三次读取
        length = fis.read(bytes);
        System.out.println(new String(bytes));

        //第四次读取
        length = fis.read(bytes);
        System.out.println(new String(bytes));

        //第五次读取
        length = fis.read(bytes);
        System.out.println(new String(bytes));

        //第六次读取
        length = fis.read(bytes);
        System.out.println(new String(bytes));

        fis.close();
    }
}
