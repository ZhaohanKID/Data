package org.Unit02.IODemo;

import java.io.*;

public class IODemo9 {
    public static void main(String[] args) throws IOException {
        //创建流对象
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("osw.txt"));
        InputStreamReader isr = new InputStreamReader(new FileInputStream("isr.txt"));

        int length = 0;
        while ((length = isr.read()) != -1) {
            osw.write(length);
            System.out.println((char)length);
        }

        //关闭资源
        osw.close();
        isr.close();
    }
}
