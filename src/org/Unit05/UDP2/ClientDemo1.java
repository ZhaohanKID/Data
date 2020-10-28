package org.Unit05.UDP2;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * TCP 协议传输：
 * 客户端：
 *      1. 创建 Socket(看成硬盘) 对象（创建成功，就代表建立连接成功）
 *      2. 读写数据，获取输出流对象，写数据
 *      3. 释放资源
 * @Author: Z.HAN
 * @Date: 2020/10/23 17:12
 */
public class ClientDemo1 {
    public static void main(String[] args) throws IOException {
        // 1. 创建 Socket(看成硬盘) 对象
        /*
            127.0.0.1是一个回环地址，指本机
            构造方法：
                Socket(String host, int port)
                Socket(InetAddress address, int port)
         */
        Socket socket = new Socket("127.0.0.1", 6666);
        // 2 获取流对象
        OutputStream os = socket.getOutputStream();
        // 3 写数据
        os.write("Hello, TCP".getBytes());
        // 4 释放资源
        socket.close();
        /*
        socket释放了，流自然就释放了
         */
    }
}
