package org.Unit02.File;

import java.io.*;
import java.util.Arrays;
import java.util.TreeSet;

public class StringDemo {
    public static void main(String[] args) throws IOException {
        /*BufferedInputStream bis = new BufferedInputStream(new FileInputStream("D:\\各种作业\\1.txt"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("D:\\各种作业\\2.txt"));

        TreeSet<Character> treeSet = new TreeSet<>();

        int content = 0;
        while ((content = bis.read()) != -1) {
            treeSet.add((char)content);
        }
        for (char c : treeSet) {
            bos.write(c);
        }
        bis.close();
        bos.close();*/

        // 上面那个自己写的不好，因为去重了
        BufferedReader br = new BufferedReader(new FileReader("D:\\各种作业\\1.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\各种作业\\2.txt"));

        String line = br.readLine();
        char[] chars = line.toCharArray();
        Arrays.sort(chars);

        String newLine = new String(chars);
        bw.write(newLine);
        bw.flush();
        bw.close();
        br.close();
    }
}
