package com.leetcode.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class BIOTest {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8090);

        System.out.println("step1:  new ServerSocket(8090)");
        while (true){
            Socket client = server.accept();// 会阻塞
            System.out.println("step2： client "+ client.getPort());

            new Thread(new Runnable() {
                Socket ss;
                public Runnable setSS(Socket s){
                    this.ss = s;
                    return this;
                }
                @Override
                public void run() {
                    InputStream in = null;
                    try {
                        in = ss.getInputStream();
                        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                        while (true){
                            System.out.println(reader.readLine());
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                    }
                }
            }.setSS(client), "t1").start();
        }
    }
}
