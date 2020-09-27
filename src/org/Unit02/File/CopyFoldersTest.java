package org.Unit02.File;

import java.io.*;

public class CopyFoldersTest {
    public static void main(String[] args) throws IOException {
        File srcFile = new File("D:\\各种作业\\2");
        File destFile = new File("D:\\");

        copyFolder(srcFile, destFile);
    }

    public static void copyFolder(File srcFile, File destFile) throws IOException {
        if (srcFile.isDirectory()) {
            File newFolder = new File(destFile, srcFile.getName());
            newFolder.mkdirs();
            File[] files = srcFile.listFiles();
            for (File file : files) {
                copyFolder(file, newFolder);
            }
        } else {
            File newFile = new File(destFile, srcFile.getName());
            copyFile(srcFile, newFile);
        }
    }

    public static void copyFile(File file, File newFile) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(newFile));
        byte[] bytes = new byte[1024];
        int length = 0;
        while ((length = bis.read(bytes)) != -1) {
            bos.write(bytes, 0, length);
        }
        bis.close();
        bos.close();
    }
}
