package org.Unit05.Send_Receive;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * int getLength()
 *           返回将要发送或接收到的数据的长度。
 * @Author: Z.HAN
 * @Date: 2020/9/29 8:13
 */
public class ReceiveDemo {
    public static void main(String[] args) throws IOException {
        // 建立UDP的socket服务
        DatagramSocket ds = new DatagramSocket(10010);

        // 通过receive方法接收数据
        byte[] bytes = new byte[1024];
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length);
        ds.receive(dp);

        // 将数据包中数据解析显示
        String ip = dp.getAddress().getHostAddress();
        System.out.println("从地址为" + ip + "接收到了" + new String(dp.getData(), 0, dp.getLength()));


        // 释放资源
        ds.close();
    }
}
