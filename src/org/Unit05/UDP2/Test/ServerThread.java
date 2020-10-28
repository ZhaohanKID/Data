package org.Unit05.UDP2.Test;

import java.io.*;
import java.net.Socket;

/**
 * @Author: Z.HAN
 * @Date: 2020/10/24 10:28
 */
public class ServerThread implements Runnable {
    private Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            String ip = socket.getInetAddress().getHostAddress();
            System.out.println(ip + "连接成功！");
            // 3 将数据从Socket中读入
            BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());

            // 4 将内存中的数据写入到硬盘
            System.currentTimeMillis();
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
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
