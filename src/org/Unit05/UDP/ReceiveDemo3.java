package org.Unit05.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 *  使用UDP接收数据
 * @Author: Z.HAN
 * @Date: 2020/10/17 16:30
 */
public class ReceiveDemo3 {
    public static void main(String[] args) throws IOException {
        // 1 创建 Socket 对象
        DatagramSocket ds = new DatagramSocket(6667);
        // 2 创建数据包，这个包相当于容器，接收数据
        while (true) {
            byte[] bytes = new byte[1024];
            int length = bytes.length;
            DatagramPacket dp = new DatagramPacket(bytes, length);
            // 3 调用接收的方法
            ds.receive(dp);
            // 4 解析数据包
            // 将数据从缓冲区中取出
            byte[] bytes2 = dp.getData();
            int length2 = bytes2.length;
            String info = new String(bytes2, 0, length2);
            // 5 把信息打印在控制台上
            System.out.println(info);
        }

        // 6 释放资源
        //ds.close();
    }
}
