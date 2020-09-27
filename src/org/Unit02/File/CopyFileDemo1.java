package org.Unit02.File;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyFileDemo1 {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("D:\\各种作业\\1.txt");
        FileWriter fw = new FileWriter("D:\\各种作业\\2.txt");

        //写数据
        /*int content = 0;
        while ((content = fr.read()) != -1) {
            fw.write(content);
        }*/

        char[] chars = new char[1024];
        int length = 0;
        while ((length = fr.read(chars)) != -1) {
            fw.write(chars, 0, length);
            fw.flush(); // 这个千万不能忘记。
        }

        fr.close();
        fw.close();
    }
}
