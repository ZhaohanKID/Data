package org.Unit02.File;

import java.io.*;

public class ObjectOutputStreamDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        write();
        //read();
    }

    private static void read() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\各种作业\\oos.txt"));
        Object o = ois.readObject();
        System.out.println(o);
        ois.close();
    }

    private static void write() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("oos.txt"));
        Student student = new Student("Allen", 90, 90, 90);
        oos.writeObject(student);
        oos.close();
    }
}
