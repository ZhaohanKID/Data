package org.Unit05.UDP;

import java.io.IOException;
import java.net.*;

/**
 * @Author: Z.HAN
 * @Date: 2020/10/17 16:45
 */
public class SendDemo2 {
    public static void main(String[] args) throws IOException {
        // 1 创建 Socket 对象
        DatagramSocket ds = new DatagramSocket();
        // 2 创建数据，打包
        byte[] bytes = "hello".getBytes();
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("192.168.2.109"), 12306);
        // 3 发送
        ds.send(dp);
        // 4 关闭资源
        ds.close();
    }
}
