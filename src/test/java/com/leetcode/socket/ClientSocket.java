package com.leetcode.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

class ClientSocket {
    public static void main(String[] args) throws IOException {
        System.out.println("start ...");
        Socket socket = new Socket("localhost",7890);
        InputStream s = socket.getInputStream();
        byte[] buf = new byte[1024];
        int len = 0;
        while ((len = s.read(buf)) != -1) {
            System.out.println(new String(buf, 0, len));
        }
    }
}
