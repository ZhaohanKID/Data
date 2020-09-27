package org.Unit02.File;

import java.io.File;

/**
 *  File类的构造方法
 *      public File(String pathname):根据路径名获得File对象
 *      public File(String parent, String child)
 *      public File(File parent, String child)
 *
 *      路径分类：
 *          相对路径：相对与当前项目的路径
 *          绝对路径：含盘符的路径都是绝对路径
 */

public class FileDemo1 {
    public static void main(String[] args) {
        //public File(String pathname):根据路径名获得File对象
        File file = new File("D:\\各种作业\\2");

        //public File(String parent, String child)
        File file1 = new File("D:\\各种作业", "2");

        //public File(File parent, String child)
        File file2 = new File("D:\\各种作业");
        File file3 = new File(file2, "2");

        System.out.println(file.mkdir());
    }
}
