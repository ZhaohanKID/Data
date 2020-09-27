package org.Unit02.File;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

public class MyBufferedReader {
    private Reader reader;

    //写方法时候传入的是抽象类Reader，而在测试类中传入的是具体的实现子类FileReader，这里运用了多态。
    //MyBufferedReader mbr = new MyBufferedReader(new FileReader("D:\\各种作业\\素材.txt"));
    public MyBufferedReader(Reader reader) {
        this.reader = reader;
    }

    public String readLine() throws IOException {

        StringBuilder stb = new StringBuilder();

        int ch = 0;
        while ((ch = reader.read()) != -1) {
            if (ch == '\r') {
                continue;
            }
            if (ch == '\n') {
                return stb.toString();
            } else {
                stb.append((char) ch);
            }
        }
        if (stb.length() > 0) {
            return stb.toString();
        }
        return null;
    }
    public void close() throws IOException {
        reader.close();
    }
}
