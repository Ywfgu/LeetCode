package com.leetcode.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class MultiplexingTest {
    private ServerSocketChannel server = null;
    private Selector selector = null;
    int port = 9090;

    public void initServer(){
        try {
            server = ServerSocketChannel.open();
            server.configureBlocking(false);
            server.bind(new InetSocketAddress(port));

            //如果在epoll模型下， open --> epoll_create -> fd3
            selector = Selector.open();// select poll *epoll 优先选择epoll 但是可以-D修正

            // server 约等于 listen 状态的 fd4
            /*
            register
            如果：
            select , poll: jvm里开辟一个数组 fd4放进去
            epoll: epoll_ctl(fd3, ADD, fd4, EPOLLIN
             */
            server.register(selector, SelectionKey.OP_ACCEPT);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() throws IOException {
        initServer();
        System.out.println("服务器启动了。。。");
        while (true){
            Set<SelectionKey> keys = selector.keys();
            System.out.println(keys.size() + "  size");

            //1, 调用多路复用器（select, poll  or epoll(epoll_wait))
            /*
            select() 是啥意思：
            1. select, poll 其实是 内核的select
            2. epoll: 其实内核的 epoll_wait()
             */

            while (selector.select(500) > 0 ){
                Set<SelectionKey> selectionKeys = selector.selectedKeys(); //返回的有状态的fd集合
                Iterator<SelectionKey> iter = selectionKeys.iterator();

                while (iter.hasNext()){
                    SelectionKey key = iter.next();
                    iter.remove();
                    if(key.isAcceptable()){
                        //
                        acceptHandler(key);
                    }else if(key.isReadable()){
                        readHandler(key);
                    }
                }
            }
        }
    }

    private void readHandler(SelectionKey key) {
        SocketChannel client = (SocketChannel) key.channel();
        ByteBuffer buffer = (ByteBuffer) key.attachment();
        buffer.clear();
        int read = 0;

        while (true){

        }
    }

    private void acceptHandler(SelectionKey key) {

        try {
            ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
            SocketChannel client = null;
            client = ssc.accept();
            client.configureBlocking(false);
            ByteBuffer buffer = ByteBuffer.allocate(8192);

            client.register(selector, SelectionKey.OP_READ, buffer);
            System.out.println("新客户端：" + client.getRemoteAddress());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
