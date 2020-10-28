package org.Unit05.UDP2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: Z.HAN
 * @Date: 2020/10/24 9:16
 */
public class ServerDemo5 {
    public static void main(String[] args) throws IOException {
        // 1 创建服务器 ServerSocket
        ServerSocket serverSocket = new ServerSocket(6666);
        // 2 监听客户端连接
        System.out.println("等待客户端连接。。");
        Socket socket = serverSocket.accept();
        String ip = socket.getInetAddress().getHostAddress();
        System.out.println(ip + "连接成功！");
        // 3 将数据从Socket中读入
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());

        // 4 将内存中的数据写入到硬盘
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("E:\\scenery2.png"));

        // 读写操作
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = bis.read(bytes)) != -1) {
            bos.write(bytes, 0, len);
            bos.flush();
        }

        // 给客户端反馈信息
        OutputStream os = socket.getOutputStream();
        os.write("图片上传成功。。".getBytes());

        bis.close();
        bos.close();
        socket.close();
    }
}
