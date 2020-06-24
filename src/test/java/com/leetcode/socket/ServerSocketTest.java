package com.leetcode.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.locks.LockSupport;

public class ServerSocketTest {

    public static void main(String[] args) throws IOException {
        System.out.println(1);
        ServerSocket socket = new ServerSocket(7890);
        while (true){
            socket.accept();
        }
    }
}
