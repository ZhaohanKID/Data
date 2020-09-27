package org.Unit02.LoginTest.Test;

import org.Unit02.LoginTest.Dao.Impl.UserDaoImpl;
import org.Unit02.LoginTest.Dao.UserDao;

import java.util.Scanner;

public class Login_Register_Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserDao userDao = new UserDaoImpl();

        while (true) {
            System.out.println("-------------------------");
            System.out.println("请输入您的操作：");
            System.out.println("1.登录");
            System.out.println("2.注册");
            System.out.println("3.退出");
            System.out.println("-------------------------");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("请输入用户名：");
                    String login_name = sc.next();
                    System.out.println("请输入密码：");
                    String login_pwd = sc.next();

                    boolean login_flag = userDao.UserLogin(login_name, login_pwd);
                    if (login_flag) {
                        System.out.println("登录成功！");
                    } else {
                        System.out.println("用户名或密码错误！");
                    }
                    break;
                case 2:
                    System.out.println("请输入用户名：");
                    String register_name = sc.next();
                    System.out.println("请输入密码：");
                    String register_pwd = sc.next();

                    boolean register_flag = userDao.UserRegister(register_name, register_pwd);
                    if (register_flag) {
                        System.out.println("注册成功！");
                    } else {
                        System.out.println("注册失败！");
                    }

                    break;
                case 3:
                    System.out.println("感谢使用，再见！");
                    System.exit(0);
            }

        }
    }
}
