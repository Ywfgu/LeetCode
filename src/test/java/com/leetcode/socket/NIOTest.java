package com.leetcode.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.LinkedList;

public class NIOTest {
    public static void main(String[] args) throws IOException, InterruptedException {
        LinkedList<SocketChannel> clients = new LinkedList<>();

        ServerSocketChannel ss = ServerSocketChannel.open();
        ss.bind(new InetSocketAddress(9090));
        ss.configureBlocking(false);

        while (true){
            Thread.sleep(1000);
            SocketChannel client = ss.accept();
            if(null == client){
                System.out.println("null...");
            }else {
                client.configureBlocking(false);
                int port = client.socket().getPort();
                System.out.println("client...port:" + port);
                clients.add(client);
            }

            ByteBuffer buffer = ByteBuffer.allocateDirect(4096);
            for (SocketChannel c : clients) {// 弊端： C10K问题导致这里会有性能浪费
                int num = c.read(buffer);
                if(num > 0){
                    buffer.flip();
                    byte[] aa  = new byte[buffer.limit()];
                    buffer.get(aa);
                    String b = new String(aa);
                    System.out.println(c.socket().getPort() + ":" + b);
                    buffer.clear();
                }
            }

        }
    }
}
