package org.Unit05.Send_Receive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *  从键盘录入数据进行发送，如果录入到520，那么发送端就结束输入数据
 * @Author: Z.HAN
 * @Date: 2020/9/29 8:40
 */
public class SearchSendDemo {
    public static void main(String[] args) throws IOException {
        // 建立UDP的socket服务
        DatagramSocket ds = new DatagramSocket();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        while ((line = br.readLine()) != null) {
            if ("520".equals(line)) {
                byte[] bytes = line.getBytes();
                DatagramPacket dp = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("192.168.1.3"), 10000);
                ds.send(dp);
                break;
            }
            // 将要发送的数据封装成数据包
            byte[] bytes = line.getBytes();
            DatagramPacket dp = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("192.168.1.3"), 10000);
            ds.send(dp);
        }


        // 释放资源
        ds.close();
    }
}
