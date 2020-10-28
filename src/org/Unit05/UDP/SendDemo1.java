package org.Unit05.UDP;

import java.io.IOException;
import java.net.*;

/**
 *  通过 UDP 发送数据：UDP不需要建立连接，所以要将数据打包
 * @Author: Z.HAN
 * @Date: 2020/10/17 16:08
 */
public class SendDemo1 {
    public static void main(String[] args) throws IOException {
        // 1 创建 Socket 对象
        /*
          通过查询API，我们发现Socket类是用于
          TCP协议 的，我们要使用DatagramSocket这个类
        */
        DatagramSocket ds = new DatagramSocket();
        // 2 创建数据，打包
        String info = "UDP 传输协议";
        // 数据
        byte[] bytes = info.getBytes();
        // 长度
        int length = bytes.length;
        // ip地址
        InetAddress inetAddress = InetAddress.getByName("DESKTOP-9KSQ2RU");
        // 端口号
        int port = 6666;
        // 打包需要另一个类，DatagramPacket
        DatagramPacket dp = new DatagramPacket(bytes, length, inetAddress, port);

        // 3 调用 Socket 对象发送的方法
        ds.send(dp);
        // 4 释放资源
        ds.close();
    }
}
