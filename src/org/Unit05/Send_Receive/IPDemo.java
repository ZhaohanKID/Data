package org.Unit05.Send_Receive;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Author: Z.HAN
 * @Date: 2020/9/28 13:49
 */
public class IPDemo {
    public static void main(String[] args) throws UnknownHostException {
        // 获取地址对象
        InetAddress address = InetAddress.getByName("DESKTOP-9KSQ2RU"); // 这里传入另一台电脑的IP地址，就可以访问到那台电脑的主机名

        String name = address.getHostName();
        String ip = address.getHostAddress();

        System.out.println(name + "----" + ip);
        // DESKTOP-9KSQ2RU----169.254.185.155
    }
}
