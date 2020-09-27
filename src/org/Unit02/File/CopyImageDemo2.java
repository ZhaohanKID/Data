package org.Unit02.File;

import java.io.*;

/**
 *  用四种方法复制一张图片，计时，比较效率。
 */

public class CopyImageDemo2 {
    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();

        //copy_method_1("D:\\各种作业\\1 .png", "1 .png");
        //copy_method_2("D:\\各种作业\\1 .png", "1 .png");
        //copy_method_3("D:\\各种作业\\1 .png", "1 .png");
        copy_method_4("D:\\各种作业\\1 .png", "1 .png");

        long endTime = System.currentTimeMillis();

        System.out.println("总耗时：" + (endTime - startTime) + "毫秒");
    }
    // 一次读取一个字节
    public static void copy_method_1(String srcString, String destString) throws IOException {
        FileInputStream fis = new FileInputStream(srcString);
        FileOutputStream fos = new FileOutputStream(destString);
        int content = 0;
        while ((content = fis.read()) != -1) {
            fos.write(content);
        }
        fis.close();
        fos.close();
    }
    // 一次读取一个字节数组
    public static void copy_method_2(String srcString, String destString) throws IOException {
        FileInputStream fis = new FileInputStream(srcString);
        FileOutputStream fos = new FileOutputStream(destString);
        byte[] bytes = new byte[1024];
        int length = 0;
        while ((length = fis.read(bytes)) != -1) {
            fos.write(bytes, 0, length);
        }
        fis.close();
        fos.close();
    }
    // 高效流
    public static void copy_method_3(String srcString, String destString) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcString));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destString));
        int content = 0;
        while ((content = bis.read()) != -1) {
            bos.write(content);
        }
        bis.close();
        bos.close();
    }
    public static void copy_method_4(String srcString, String destString) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcString));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destString));
        byte[] bytes = new byte[1024];
        int length = 0;
        while ((length = bis.read(bytes)) != -1) {
            bos.write(bytes, 0, length);
        }
        bis.close();
        bos.close();
    }
}
