package org.Unit05.TCP;

import java.io.*;
import java.net.Socket;

/**
 *  需求：客户端从键盘录入数据，在服务端分别以文本和文件的形式输出
 * @Author: Z.HAN
 * @Date: 2020/9/30 15:47
 */
public class ClientTest1 {
    public static void main(String[] args) throws IOException {
        // 创建客户端的Socket对象，这里要传入IP和端口号
        Socket socket = new Socket("192.163.1.3", 12306);
        // 通过客户端流对象发送数据
        // 实现键盘录入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 将字节流转换为字符流
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        String line = null;
        while ((line = br.readLine()) != null) {
            bw.write(line);
            bw.newLine();
            bw.flush();
        }
        // 关闭客户端
        socket.close();
    }
}
