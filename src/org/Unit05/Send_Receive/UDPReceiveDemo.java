package org.Unit05.Send_Receive;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 接收端传输步骤：
 *      1.建立UDP的Socket服务
 *      2.通过receive方法接收数据
 *      3.将收到的数据存储到数据包对象中
 *      4.通过数据包对象的功能来完成对接收到数据进行解析
 *      5.关闭资源
 * @Author: Z.HAN
 * @Date: 2020/9/28 18:50
 */
public class UDPReceiveDemo {
    public static void main(String[] args) throws IOException {
        // 建立UDP的Socket服务
        DatagramSocket ds = new DatagramSocket(10010);

        // 通过receive方法接收数据
        byte[] bytes = new byte[1024];
        int length = bytes.length;
        DatagramPacket dp = new DatagramPacket(bytes, length);

        // 将接收到的数据存储到数据包对象中
        ds.receive(dp);

        // 解析
        byte[] data = dp.getData();
        int size = dp.getLength();
        System.out.println(new String(data, 0, size));

        // 释放资源
        ds.close();
    }
}
