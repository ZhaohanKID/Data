package org.Unit02.File;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * File类创建功能
 *      public boolean createNewFile():创建文件
 *      public boolean mkdir():创建文件夹，如果文件夹已经存在，则不创建，返回false
 *              只能创建单级文件夹
 *      public boolean mkdirs():可以创建多级文件夹
 *
 * File类删除功能
 *      public boolean delete():删除文件或目录
 */

public class FileDemo2 {
    public static void main(String[] args) throws IOException {
        //获取file对象
        File file = new File("D:\\各种作业\\1.txt");
        //创建文件
        System.out.println(file.createNewFile());

        //获取功能
        System.out.println(file.lastModified());

        Date date = new Date(1599802936804L);
        SimpleDateFormat adf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        String s = adf.format(date);
        System.out.println(s);
    }
}
