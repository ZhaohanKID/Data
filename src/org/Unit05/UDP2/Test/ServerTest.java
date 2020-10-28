package org.Unit05.UDP2.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: Z.HAN
 * @Date: 2020/10/24 9:16
 */
public class ServerTest {
    public static void main(String[] args) throws IOException {
        // 1 创建服务器 ServerSocket
        ServerSocket serverSocket = new ServerSocket(6666);
        // 2 监听客户端连接
        System.out.println("等待客户端连接。。");
        Socket socket = serverSocket.accept();
        while (true) {
            new Thread(new ServerThread(socket)).start();
        }

    }
}
