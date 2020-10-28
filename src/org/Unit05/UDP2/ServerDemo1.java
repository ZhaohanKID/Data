package org.Unit05.UDP2;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务器端：
 *      1. 创建服务器端Socket-ServerSocket
 *      2. 监听客户端连接，一旦监听到客户端发来的Socket，就开始工作
 *      3. 获取输入流，读取数据，显示在控制台
 *      4. 释放资源
 * @Author: Z.HAN
 * @Date: 2020/10/23 17:12
 */
public class ServerDemo1 {
    public static void main(String[] args) throws IOException {
        // 1 创建 ServerSocket
        /*
        构造方法：
            ServerSocket(int port)
            套接字由IP 地址，端口号和其他信息等组成
         */
        ServerSocket serverSocket = new ServerSocket(6666);
        // 2 监听客户端连接
        System.out.println("等待客户机连接");
        Socket socket = serverSocket.accept(); // 阻塞方法
        String ip = socket.getInetAddress().getHostAddress();
        System.out.println(ip + "已经连接");
        // 3 获取输入流，读取数据显示在控制台
        InputStream is = socket.getInputStream();
        // 创建缓冲区
        byte[] bytes = new byte[1024];
        // 实际数据长度
        int len = 0;
        String info = "";
        while ((len = is.read(bytes)) != -1) {
            info = new String(bytes, 0, len);
        }
        System.out.println(ip + ":" + info);
    }
}
