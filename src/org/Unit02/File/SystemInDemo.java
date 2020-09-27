package org.Unit02.File;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class SystemInDemo {
    public static void main(String[] args) throws IOException {
        // 这里传入的 System.in 是一个具体的构造方法的参数。
        //Scanner sc = new Scanner(System.in);

        /*InputStream in = System.in;

        // 一次读取一个字节，中文会出现乱码。所以要一次读取一个字符。
        int content = 0;
        while ((content = in.read()) != -1) {
            System.out.println(content);
        }*/

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入内容：");
        String line = br.readLine();
        System.out.println(line);
    }
}
