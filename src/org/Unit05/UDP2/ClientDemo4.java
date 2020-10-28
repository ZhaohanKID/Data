package org.Unit05.UDP2;

import java.io.*;
import java.net.Socket;

/**
 *  客户端从键盘录入数据
 * @Author: Z.HAN
 * @Date: 2020/10/23 18:26
 */
public class ClientDemo4 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 6666);

        // 2 从文件读取数据
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("b.txt"));
        // 3 将用户输入数据写入 Socket 中，获取输出流
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        String line = null;
        while ((line = br.readLine()) != null) {
            bw.write(line);
            bw.newLine();
            bw.flush();

            /*if (line.equals("88")) {
                break;
            }*/
        }

        socket.shutdownOutput();

        // 接收服务器端的消息
        /*InputStream is = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len = 0;
        String info = null;
        while ((len = is.read(bytes)) != -1) {
            info = new String(bytes, 0, len);
        }
        System.out.println(info);*/

        // 这里也可以用缓冲流
        String info = null;
        BufferedReader br2 = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String info2 = null;
        while ((info = br2.readLine()) != null) {
            System.out.println(info);
        }

        // 释放资源
        br2.close();
        bw.close();
        br.close();
        socket.close();
    }
}
