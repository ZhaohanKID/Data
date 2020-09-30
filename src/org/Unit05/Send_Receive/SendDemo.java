package org.Unit05.Send_Receive;

import java.io.IOException;
import java.net.*;

/**
 * @Author: Z.HAN
 * @Date: 2020/9/29 8:13
 */
public class SendDemo {
    public static void main(String[] args) throws IOException {
        // 建立发送端的Socket服务
        DatagramSocket ds = new DatagramSocket();

        // 将要传输的数据封装成数据包
        byte[] bytes = "Hello, Java, Python, PHP".getBytes();
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("192.168.1.3"), 10010);

        // 通过Socket服务器调用方法，发送数据包
        ds.send(dp);

        // 释放资源
        ds.close();
    }
}
