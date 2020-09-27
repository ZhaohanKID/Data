package org.Unit02.File;

/**
 *  复制图片
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyImageDemo1 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("D:\\各种作业\\1 .png");
        FileOutputStream fos = new FileOutputStream("1.png");

        int content = 0;
        while ((content = fis.read()) != -1) {
            fos.write(content);
        }

        fis.close();
        fos.close();
    }
}
