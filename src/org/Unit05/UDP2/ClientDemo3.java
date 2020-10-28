package org.Unit05.UDP2;

import java.io.*;
import java.net.Socket;

/**
 *  客户端从键盘录入数据
 * @Author: Z.HAN
 * @Date: 2020/10/23 18:26
 */
public class ClientDemo3 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 6666);
        // 2 获取客户端输入数据
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 3 将用户输入数据写入Socket中，获取输出流
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        String line = null;
        while ((line = br.readLine()) != null) {
            bw.write(line);
            bw.newLine();
            bw.flush();

            if (line.equals("88")) {
                break;
            }
        }
        // 释放资源
        bw.close();
        br.close();
        socket.close();
    }
}
