package org.Unit02.File;

import java.io.*;

public class BufferedWriterDemo1 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:\\各种作业\\1.txt")));
        BufferedWriter bw2 = new BufferedWriter(new FileWriter("D:\\1.txt"));
        bw.write("我爱你中国");
        bw.flush();
        bw.close();
    }
}
