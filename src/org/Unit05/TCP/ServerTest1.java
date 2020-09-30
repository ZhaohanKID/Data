package org.Unit05.TCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: Z.HAN
 * @Date: 2020/9/30 15:47
 */
public class ServerTest1 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12306);
        Socket socket = serverSocket.accept();
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line = null;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        socket.close();
    }
}
