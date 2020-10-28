package org.Unit05.UDP2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: Z.HAN
 * @Date: 2020/10/23 18:27
 */
public class ServerDemo3 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(6666);
        // 2 监听客户端连接，返回对应连接的socket
        System.out.println("等到用户连接。。");
        Socket socket = serverSocket.accept();
        String ip = socket.getInetAddress().getHostAddress();
        System.out.println(ip + "已经连接了。。");
        // 3 （读取）解析数据
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter bw = new BufferedWriter(new FileWriter("b.txt"));
        String line = null;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
            bw.write(line);
            bw.newLine();
            bw.flush();
        }
        // 释放资源
        br.close();
        bw.close();
        socket.close();

        /*
        先关闭客户端，就会报这个错误


        "C:\Program Files\Java\jdk-12.0.2\bin\java.exe" "-javaagent:D:\Idea.2019\IntelliJ IDEA 2019.3.3\lib\idea_rt.jar=59091:D:\Idea.2019\IntelliJ IDEA 2019.3.3\bin" -Dfile.encoding=UTF-8 -classpath D:\IntelliJ_IDEA_Project\程序\out\production\程序 org.Unit05.UDP2.ServerDemo3
等到用户连接。。
127.0.0.1已经连接了。。
赵涵
哈哈哈哈哈哈，确实是
不管走到哪里，都不要忘记初心
Exception in thread "main" java.net.SocketException: Connection reset
	at java.base/java.net.SocketInputStream.read(SocketInputStream.java:186)
	at java.base/java.net.SocketInputStream.read(SocketInputStream.java:140)
	at java.base/sun.nio.cs.StreamDecoder.readBytes(StreamDecoder.java:284)
	at java.base/sun.nio.cs.StreamDecoder.implRead(StreamDecoder.java:326)
	at java.base/sun.nio.cs.StreamDecoder.read(StreamDecoder.java:178)
	at java.base/java.io.InputStreamReader.read(InputStreamReader.java:185)
	at java.base/java.io.BufferedReader.fill(BufferedReader.java:161)
	at java.base/java.io.BufferedReader.readLine(BufferedReader.java:326)
	at java.base/java.io.BufferedReader.readLine(BufferedReader.java:392)
	at org.Unit05.UDP2.ServerDemo3.main(ServerDemo3.java:24)

Process finished with exit code 1

         */
    }
}
