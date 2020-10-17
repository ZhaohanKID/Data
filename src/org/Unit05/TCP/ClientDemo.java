package org.Unit05.TCP;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Collections;

/**
 * 客户端：Socket，该类是一个客户端套接字
 *      TCP发送端传输步骤：
 *          1、建立客户端的Socket服务，明确要链接的服务器（主机名和端口号）
 *          2、如果链接建立成功，就表明已经建立了数据传输通道，就可以在该通
 *              道通过IO流进行数据的读取和写入，该通道称为Socket流，Socket
 *              流中既有读取流，又有写入流
 *          3、通过Socket对象获取这两个流
 *          4、通过流对象，可以对数据进行传输
 *          5、传输完毕，关闭资源
 * @Author: Z.HAN
 * @Date: 2020/9/29 9:26
 */
public class ClientDemo {
    public static void main(String[] args) throws IOException {
        // 建立客户端的Socket服务，明确连接的IP和端口
//        Socket socket = new Socket(InetAddress.getByName("192.168.1.3"), 9999)
        Socket socket = new Socket("192.168.1.3", 9999);

        OutputStream os = socket.getOutputStream();
        os.write("Hello, Java, World".getBytes());

        socket.close();
    }
}
