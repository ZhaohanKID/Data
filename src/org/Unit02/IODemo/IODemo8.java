package org.Unit02.IODemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IODemo8 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("D:\\各种作业\\1.png");
        FileOutputStream fos = new FileOutputStream("D:\\各种作业\\2.png");

        int content = 0;
        while ((content = fis.read()) != -1) {

        }
    }
}
