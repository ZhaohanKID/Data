package org.Unit05.TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * ServerDemo2输出的结果是：数据解析完毕！服务器，你好吗？
 *      （数据解析完毕后并且收到反馈才能使得想要传输的数据 服务器你好吗？传递过去 ）
 * ClientDemo2输出的结果是：接收到了，over！
 *      （这个就是客户端接收到的服务器给的反馈）
 * @Author: Z.HAN
 * @Date: 2020/9/30 15:30
 */
public class ClientDemo2 {
    public static void main(String[] args) throws IOException {
        // 建立客户端的Socket服务，明确连接的IP和端口
        Socket socket = new Socket("192.168.1.3", 11111);
        // 通过客户端流对象发送数据
        OutputStream os = socket.getOutputStream();
        os.write("服务器，你好吗？".getBytes());
        // 定义一个输入流接收服务器返回的数据
        InputStream is = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int length = is.read(bytes);
        String result = new String(bytes, 0, length);
        System.out.println(result);
        // 关闭客户端
        socket.close();
    }
}
