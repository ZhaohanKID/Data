package org.Unit05.UDP2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @Author: Z.HAN
 * @Date: 2020/10/23 17:44
 */
public class ClientDemo2 {
    public static void main(String[] args) throws IOException {
        // 1 建立 Socket 连接
        Socket socket = new Socket("127.0.0.1", 6666);
        // 2 获取输出流，发送数据
        OutputStream os = socket.getOutputStream();
        os.write("你好，我想给你发个消息。。".getBytes());

        // 为了防止两个流相互等待，需要关闭输出流 read也会阻塞
        socket.shutdownOutput();

        // 3 接收服务器端回复的消息
        InputStream is = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len = 0;
        String info = "";
        while ((len = is.read(bytes)) != -1) {
            info = new String(bytes, 0, len);
        }
        System.out.println(info);

        // 示范资源
        socket.close();
        is.close();
    }
}
