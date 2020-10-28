package org.Unit05.UDP2;

import java.io.*;
import java.net.Socket;

/**
 * @Author: Z.HAN
 * @Date: 2020/10/24 9:16
 */
public class ClientDemo5 {
    public static void main(String[] args) throws IOException {
        // 1 创建 Socket 对象
        Socket socket = new Socket("127.0.0.1", 6666);
        // 2 从图片读取数据
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("E:\\scenery.jpg"));
        // 3 将读到内存中的数据写到Socket
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());

        // 4 读写操作
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = bis.read(bytes)) != -1) {
            bos.write(bytes, 0, len);
            bos.flush();
        }

        // 告诉服务器我传递完毕了
        socket.shutdownOutput();

        // 接收反馈信息
        BufferedInputStream bis2 = new BufferedInputStream(socket.getInputStream());
        byte[] bytes2 = new byte[1024];
        int len2 = bis2.read(bytes2);
        String info = new String(bytes2, 0, len2);
        System.out.println(info);

        bis.close();
        bis2.close();
        socket.close();
    }
}
