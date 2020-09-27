package org.Unit02.Properties;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

public class PropertiesDemo2 {
    public static void main(String[] args) throws IOException {
        Properties prop = new Properties();
        Reader reader = new FileReader("D:\\各种作业\\1.txt");
        prop.load(reader);
        System.out.println(reader); // java.io.FileReader@7291c18f
        reader.close();
        System.out.println(prop);
    }
}
