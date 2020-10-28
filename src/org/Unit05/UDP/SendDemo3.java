package org.Unit05.UDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *  通过 UDP 发送数据
 * @Author: Z.HAN
 * @Date: 2020/10/17 16:08
 */
public class SendDemo3 {
    public static void main(String[] args) throws IOException {
        // 1 创建 Socket 对象
        /*
          通过查询API，我们发现Socket类是用于
          TCP协议 的，我们要使用DatagramSocket这个类
        */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        while ((line = br.readLine()) != null) {
            DatagramSocket ds = new DatagramSocket();
            // 数据
            byte[] bytes = line.getBytes();
            // ip地址
            InetAddress inetAddress = InetAddress.getByName("192.168.2.109");
            // 端口号
            int port = 6667;
            // 打包需要另一个类，DatagramPacket
            DatagramPacket dp = new DatagramPacket(bytes, bytes.length, inetAddress, port);

            // 3 调用 Socket 对象发送的方法
            ds.send(dp);
        }

        // 4 释放资源
        //ds.close();
    }
}
