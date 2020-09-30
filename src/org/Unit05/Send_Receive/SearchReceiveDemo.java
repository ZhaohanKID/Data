package org.Unit05.Send_Receive;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @Author: Z.HAN
 * @Date: 2020/9/29 8:42
 */
public class SearchReceiveDemo {
    public static void main(String[] args) throws IOException {
        // 建立UDP的socket服务
        DatagramSocket ds = new DatagramSocket(10000);
        // 想要多次接收数据，只需要将这一部分代码用while循环包裹起来
        while (true) {
            // 将接受到的数据存储到数据包对象中
            // 通过receive方法接收数据
            byte[] bytes = new byte[1024];
            DatagramPacket dp = new DatagramPacket(bytes, bytes.length);
            ds.receive(dp);
            // 解析数据
            String ip = dp.getAddress().getHostAddress();
            System.out.println("从" + ip + "接收到的数据为" + new String(dp.getData(), 0, dp.getLength()));
        }

    }
}
