package org.Unit05.InetAddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Author: Z.HAN
 * @Date: 2020/10/17 15:06
 */
public class InetAddressDemo1 {
    public static void main(String[] args) throws UnknownHostException {
        // 通过静态方法获取对象
        InetAddress inetAddress = InetAddress.getByName("DESKTOP-9KSQ2RU");

        // 获取主机名
        String name = inetAddress.getHostName();

        // 获取主机地址
        String ip = inetAddress.getHostAddress();
        System.out.println(name);
        System.out.println(ip);
        /*
            DESKTOP-9KSQ2RU
            169.254.185.155

            DESKTOP-9KSQ2RU
            192.168.2.109
         */
    }
}
