package org.Unit02.LoginTest.Dao.Impl;

import org.Unit02.LoginTest.Dao.UserDao;

import java.io.*;
import java.util.Properties;
import java.util.Set;

public class UserDaoImpl implements UserDao {
    @Override
    public boolean UserLogin(String name, String password) {
        Reader reader = null;
        try {
            // 将数据读到集合中。
            reader = new FileReader("D:\\IntelliJ IDEA程序\\程序\\src\\org\\Unit02\\LoginTest\\login.properties");
            Properties prop = new Properties();
            prop.load(reader);

            Set<String> set = prop.stringPropertyNames();
            for (String username : set) {
                if (name.equals(username) && password.equals(prop.getProperty(username))) {
                    return true;
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("错误：数据未找到");
        } catch (IOException e) {
            System.out.println("错误：数据读取错误");
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                System.out.println("错误：文件已关闭");
            }
        }
        return false;
    }

    @Override
    public boolean UserRegister(String name, String password) {
        Reader reader = null;
        Writer writer = null;

        try {
            reader = new FileReader("D:\\IntelliJ IDEA程序\\程序\\src\\org\\Unit02\\LoginTest\\login.properties");
            Properties prop = new Properties();
            prop.load(reader);

            Set<String> set = prop.stringPropertyNames();
            for (String username : set) {
                // 名字相等直接错误
                if (name.equals(username)) {
                    System.out.println("该用户名已存在！");
                    return false;
                } else {
                    writer = new FileWriter("D:\\IntelliJ IDEA程序\\程序\\src\\org\\Unit02\\LoginTest\\login.properties");
                    prop.setProperty(name, password);
                    prop.store(writer, "version 1.1");

                    return true;
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("错误：文件未找到");
        } catch (IOException e) {
            System.out.println("错误：数据读取错误");
        } finally {

            try {
                if (reader != null) {
                    reader.close();
                }
                if (writer != null) {
                    writer.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
