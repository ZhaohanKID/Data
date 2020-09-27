package org.Unit02.Properties;

import java.io.*;
import java.util.Properties;
import java.util.Set;

public class PropertiesTest {
    public static void main(String[] args) throws IOException {
        Properties prop = new Properties();
        Reader reader = new FileReader("D:\\各种作业\\1.txt");
        prop.load(reader);

        reader.close();
        Set<String> set = prop.stringPropertyNames();
        for (String name : set) {
            if ("Java".equals(name)) {
                prop.setProperty(name, "250");
                System.out.println("查找字段存在，修改成功！");
                break;
            }
        }

        Writer writer = new FileWriter("D:\\各种作业\\1.txt");
        prop.store(writer, null);
        writer.close();
    }
}
