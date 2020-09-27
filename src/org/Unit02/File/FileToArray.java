package org.Unit02.File;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class FileToArray {
    public static void main(String[] args) throws IOException {
        ArrayList<String> arrayList = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("D:\\各种作业\\bw.txt"));
        String line = null;
        while ((line = br.readLine()) != null) {
            arrayList.add(new String(line));
        }
        /*
            疯了，迭代器是遍历集合的。
        Iterator<String> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            String s = (String) iterator.next();

        }*/
        br.close();
        System.out.println(arrayList);
    }
}
