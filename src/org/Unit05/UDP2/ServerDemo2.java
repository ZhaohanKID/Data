package org.Unit05.UDP2;

import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *  TCP 实现，客户端和服务端收发消息
 * @Author: Z.HAN
 * @Date: 2020/10/23 17:43
 */
public class ServerDemo2 {
    public static void main(String[] args) throws IOException {
        // 1 创建服务器Socket
        ServerSocket serverSocket = new ServerSocket(6666);
        // 2 监听客户端连接，并返回相应的Socket对象
        System.out.println("等待客户机连接");
        // accept 一次接收一个客户机的消息，因为一次创建只一个socket对象
        Socket socket = serverSocket.accept();
        String ip = socket.getInetAddress().getHostAddress();
        System.out.println(ip + "已经连接。。。");
        // 3 获取输入流对象
        InputStream is = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len = 0;
        String info = "";
        while ((len = is.read(bytes)) != -1) {
            info = new String(bytes, 0, len);
        }
        System.out.println(ip + ":" + info);
        // 发送消息给客户端
        OutputStream os = socket.getOutputStream();
        os.write("我收到了。。".getBytes());
        // 释放资源
        os.close();
        is.close();
        socket.close();
    }
}
