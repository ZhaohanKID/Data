package org.Unit05.TCP;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: Z.HAN
 * @Date: 2020/9/30 14:13
 */
public class ServerDemo {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        // 通过accept方法获取客户端对象
        Socket socket = serverSocket.accept(); //阻塞，直到有客户端连接。
        // 接收数据
        InputStream is = socket.getInputStream();

        // 解析
        byte[] bytes = new byte[1024];
        int length = is.read(bytes);
        System.out.println(new String(bytes, 0, length));

        // 一般不会关闭服务器
        //serverSocket.close();
        socket.close(); // 有很多的客户端链接这个服务器，当一个客户端连接完后，就断掉连接。
    }
}
