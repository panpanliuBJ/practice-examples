package com.finley.studydemo.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Need class description here...
 *
 * @Author: liupanpan
 * @Date: 2020/5/4
 * @Copyright (c) 2013, bitmain.com All Rights Reserved
 */

public class NIOClient {

    /**
     * 通道
     */
    SocketChannel channel;

    public static void main(String[] args) throws IOException, InterruptedException {
        NIOClient client = new NIOClient();

        /*ExecutorService executorService = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 1000; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        client.initClient("localhost", 8080);
                        client.sendAndRecv("I am a client " + Thread.currentThread().getName());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        executorService.awaitTermination(1000, TimeUnit.SECONDS);*/

        client.initClient("localhost", 8080);
        client.sendAndRecv("I am a client");
    }

    public void initClient(String host, int port) throws IOException {
        //构造socket连接
        InetSocketAddress servAddr = new InetSocketAddress(host, port);

        //打开连接
        this.channel = SocketChannel.open(servAddr);
    }

    public void sendAndRecv(String words) throws IOException {
        byte[] msg = new String(words).getBytes();
        ByteBuffer buffer = ByteBuffer.wrap(msg);
        System.out.println("Client sending: " + words);
        channel.write(buffer);
        buffer.clear();
        channel.read(buffer);
        System.out.println("Client received: " + new String(buffer.array()).trim());

        channel.close();
    }
}
