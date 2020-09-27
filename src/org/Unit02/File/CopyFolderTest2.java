package org.Unit02.File;

/**
 *  1.获取File对象
 *  2.获取数据源目录下的.docx文件
 *  3.遍历File数组，获取每个文件对应的File对象。
 *  4.把File对象进行复制
 *  5.在目的地文件夹中修改后缀名。
 */

import java.io.*;
import java.util.Objects;

public class CopyFolderTest2 {
    public static void main(String[] args) throws IOException {

        // 1.获取File对象
        File srcFolder = new File("D:\\各种作业\\2");
        File destFolder = new File("D:\\各种作业\\1");

        if (!destFolder.exists()) {
            destFolder.mkdirs();
        }
        // 过滤文件名字，只要docx结尾的
        File[] files = srcFolder.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                boolean isFile = new File(dir, name).isFile();
                boolean endName = name.endsWith(".docx");
                return isFile && endName;
            }
        });
        // 遍历得到数据源
        for (File file : files) {
            String s = file.getName();
            File newFile = new File(destFolder, s);// IO流中的目的地。
            copyFile(file, newFile);
        }

        // 在目的文件夹下修改文件名后缀。
        File[] destFolderFiles = destFolder.listFiles();
        for (File destFile : destFolderFiles) {
            String name = destFile.getName();
            String newName = name.replace(".docx", ".class");
            File newFile = new File(destFolder, newName);
            destFile.renameTo(newFile);
        }
    }

    private static void copyFile(File file, File newFile) throws IOException {
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
