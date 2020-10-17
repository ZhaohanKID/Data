package org.Unit05.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @Author: Z.HAN
 * @Date: 2020/10/17 16:52
 */
public class ReceiveDemo2 {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket(12306);
        byte[] bytes = new byte[1024];
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length);
        ds.receive(dp);
        byte[] bytes2 = dp.getData();
        String info = new String(bytes2, 0, bytes2.length);
        System.out.println(info);
        ds.close();
    }
}
