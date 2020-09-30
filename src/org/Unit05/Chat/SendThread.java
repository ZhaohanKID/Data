package org.Unit05.Chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @Author: Z.HAN
 * @Date: 2020/9/29 9:10
 */
public class SendThread implements Runnable {
    private DatagramSocket ds;

    public SendThread(DatagramSocket ds) {
        this.ds = ds;
    }

    @Override
    public void run() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String line = null;
            while ((line = br.readLine()) != null) {
                if ("520".equals(line)) {
                    byte[] bytes = line.getBytes();
                    DatagramPacket dp = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("192.168.1.3"), 10000);
                    ds.send(dp);
                    break;
                }
                byte[] bytes = line.getBytes();
                DatagramPacket dp = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("192.168.1.3"), 10010);
                ds.send(dp);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
