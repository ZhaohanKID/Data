package org.Unit02.File;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ArrayToFile {
    public static void main(String[] args) throws IOException {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Hello");
        arrayList.add("Java");
        arrayList.add("Python");
        BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\各种作业\\bw.txt"));
        for (String s : arrayList) {
            bw.write(s);
            bw.newLine();
            bw.flush();
        }
        bw.close();
    }
}
