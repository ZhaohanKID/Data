package org.Unit05.TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: Z.HAN
 * @Date: 2020/9/30 15:23
 */
public class ServerDemo2 {
    public static void main(String[] args) throws IOException {
        // 建立服务端Socket，这里要明确端口号
        ServerSocket serverSocket = new ServerSocket(11111);
        // 通过accept方法获取客户端对象，返回的是一个Socket对象
        Socket socket = serverSocket.accept();
        // 通过客户端对象流的操作，来接收数据
        InputStream is = socket.getInputStream();
        // 解析
        byte[] bytes = new byte[1024];
        int length = is.read(bytes);
        String result = new String(bytes, 0, length);
        System.out.println("数据解析完毕！" + result);
        // 那么服务端如何给客户端一个反馈呢？
        OutputStream os = socket.getOutputStream();
        os.write("接收到了，over！".getBytes());
        // 关闭客户端的连接
        socket.close();
    }
}
