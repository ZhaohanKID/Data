package org.Unit02.File;

import java.io.File;

/**
 *  获取指定目录下以 .txt 结尾的文件，并将文件名输出在控制台
 */

public class FileDemo3 {
    public static void main(String[] args) {
        File file = new File("D:\\各种作业");
        File[] files = file.listFiles();
        for (File file1 : files) {
            if (file1.getName().endsWith("docx")) {
                System.out.println(file1);
            }
        }
        /*String[] fileNames = file.list();
        for (String s : fileNames) {
            if (s.endsWith("docx")) {
                System.out.println(s);
            }
        }*/
    }
}
