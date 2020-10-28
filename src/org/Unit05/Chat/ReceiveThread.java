package org.Unit05.Chat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @Author: Z.HAN
 * @Date: 2020/9/29 9:10
 */
public class ReceiveThread implements Runnable {
    private DatagramSocket ds;

    public ReceiveThread(DatagramSocket ds) {
        this.ds = ds;
    }

    @Override
    public void run() {
        try {
            while (true) {
                // 将接受到的数据存储到数据包对象中
                // 通过receive方法接收数据
                byte[] bytes = new byte[1024];
                DatagramPacket dp = new DatagramPacket(bytes, bytes.length);
                ds.receive(dp);
                // 解析数据
                String ip = dp.getAddress().getHostAddress();
                System.out.println(new String(dp.getData(), 0, dp.getLength()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
