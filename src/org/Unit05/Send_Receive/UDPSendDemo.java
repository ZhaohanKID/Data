package org.Unit05.Send_Receive;

import java.io.IOException;
import java.net.*;

/**
 * DatagramPacket(byte[] buf, int length, InetAddress address, int port)
 * 构造数据报包，用来将长度为 length 的包发送到指定主机上的指定端口号。
 *
 * @Author: Z.HAN
 * @Date: 2020/9/28 18:25
 */
public class UDPSendDemo {
    public static void main(String[] args) throws IOException {
        // 建立发送端Socket服务
        DatagramSocket ds = new DatagramSocket();

        // 将要发送的数据封装成数据包。
        byte[] bytes = "Hello, Java, Python".getBytes(); // 将字符串转化为字节数组
        int length = bytes.length;
        InetAddress address = InetAddress.getByName("192.168.1.3");
        int port = 10010;
        DatagramPacket dp = new DatagramPacket(bytes, length, address, port);

        // 通过Socket服务调用方法，发送数据包，send
        ds.send(dp); // send方法需要一个参数send(DatagramPacket dp)

        // 释放资源
        ds.close();
    }
}
