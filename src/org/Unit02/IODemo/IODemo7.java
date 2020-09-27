package org.Unit02.IODemo;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IODemo7 {
    public static void main(String[] args) throws IOException {
        /*FileWriter fw = new FileWriter("D:\\fw.txt", true);

        String str = "HelloWorld";

        fw.write(str);
        fw.close();*/

        FileReader fr = new FileReader("D:\\fw.txt");
        int content = 0;
        while ((content = fr.read()) != -1) {
            System.out.print((char) content);
        }
        fr.close();
    }
}
