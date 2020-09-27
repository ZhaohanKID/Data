package org.Unit02.File;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MyBufferedReaderDemo {
    public static void main(String[] args) throws IOException {
        MyBufferedReader mbr = new MyBufferedReader(new FileReader("D:\\各种作业\\素材.txt"));
        String line = null;
        while ((line = mbr.readLine()) != null) {
            System.out.println(line);
        }
        mbr.close();
    }
}
