package org.Unit05.Chat;

import java.io.IOException;
import java.net.DatagramSocket;

/**
 * @Author: Z.HAN
 * @Date: 2020/9/29 9:03
 */
public class ChatDemo {
    public static void main(String[] args) throws IOException {
        DatagramSocket sendDs = new DatagramSocket();
        DatagramSocket receiveDs = new DatagramSocket(10086);

        SendThread st = new SendThread(sendDs);
        ReceiveThread rt = new ReceiveThread(receiveDs);

        // 要写发送端和接收端的Thread

        Thread t1 = new Thread(st);
        Thread t2 = new Thread(rt);

        t1.start();
        t2.start();
    }
}
